package test240719.object1;

import java.util.Random;

public class AnimalManager {
	public static void main(String[] args) {
		Animal[] animal = new Animal[5];
		Random random = new Random();
		
		String[] dogName = {
				"인절미", "댕댕이", "개죽이", "초코", "바둑이", 
				"누렁이", "까미", "토리", "콩이", "두부"};
		String[] dogKind = {
				"골든 리트리버", "이탈리안 그레이하운드", "시고르자브", "말티즈", "비글", 
				"푸들", "셰퍼드", "불독", "달마시안", "차우차우"};
		
		String[] catName = {
				"고등어", "나비", "초코", "순이", "미미", 
				"치즈", "마루", "냥이", "코코", "구름"};
		String[] catKind ={
				"코리안 숏헤어", "메인쿤", "러시안 블루", "스핑크스", "페르시안",
				"뱅갈", "샴", "아비시니안", "터키시앙고라", "노르웨이 숲"};
		String[] location = {
				"길거리", "미국 메인 주", "러시아", "캐나다", "이란", 
				"방글라데시", "태국", "에티오피아", "터키", "노르웨이"};
		String[] color = {
				"검정", "갈색", "회색", "흰색", "주황색", 
				"노란색", "크림색", "파랑색", "녹색", "분홍색"};

		for(int i=0; i< animal.length; i++) {
			if((Math.random() * 2) >= 1) {
				animal[i] = new Dog(
						dogName[random.nextInt(dogName.length)],
						dogKind[random.nextInt(catName.length)],
						random.nextInt(1,30)
				);
			}
			else {
				int randNum = random.nextInt(catKind.length);
				animal[i] = new Cat(
						catName[random.nextInt(catName.length)],
						catKind[randNum],
						location[randNum],
						color[random.nextInt(catName.length)]
				);
			}
			animal[i].speak();
		}
		
	}
}
