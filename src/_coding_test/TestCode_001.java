package _coding_test;

public class TestCode_001 {
	
	// https://school.programmers.co.kr/learn/courses/30/lessons/250137?language=java

	public static void main(String[] args) {
		final int HEALTH = 20; // 최대체력
		int currentHealth = HEALTH; // 현재체력
		int[] bandage = { 3, 2, 7 }; // { 시전시간, 초당 회복량, 추가 회복량 }
		int[][] attacks = { {1,15}, {5,16}, {8,6} }; // { { 공격시간, 피해량 } }
		
		int sec = 0; //현재 시간
		int attacksIndex = 0; //공격 시간 표시
		int healContinueTime = 0; //힐 지속성공 시간
		int lastAttackTime = attacks[attacks.length - 1][0]; //전체 시간 = 마지막 공격 시간
		
		for(sec = 1; sec <= lastAttackTime; sec++) {
			
			if(sec == attacks[attacksIndex][0]) { // 공격 타이밍이면
				currentHealth -= attacks[attacksIndex][1];
				attacksIndex++;
				healContinueTime = 0;
			}
			else if(currentHealth < HEALTH) { 
				//힐 한 체력이 최대체력보다 작으면 초당 회복량만큼 회복
				//힐 한 체력이 최대체력보다 크면 최대체력 - 현재체력만큼 회복 => 최대체력이 된다
				currentHealth += (currentHealth + bandage[1] <= HEALTH) ? bandage[1] : HEALTH - currentHealth;
				healContinueTime += 1;
				
				if(healContinueTime >= bandage[0]) { //시전시간동안 끊기지 않았다면
					currentHealth += (currentHealth + bandage[2] <= HEALTH) ? bandage[2] : HEALTH - currentHealth;
					healContinueTime = 0;
				}
			}
			
			if(currentHealth <= 0) {
				System.out.println("시체로 결정");
				//return -1;
			}	
			
			
			
		}
		System.out.println(currentHealth);
		//return currentHealth;
		
		
	}

}
