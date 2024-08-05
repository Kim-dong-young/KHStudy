package i.polymorphism.ex2;

public class Run {
	public static void main(String[] args) {
		// 1. 부모타입 레퍼런스(참조변수)로 부모객체를 다루는 경우
		Car c1 = new Car("red","gasoline",2020);
		c1.drive();
		
		// 2. 자식타입 레퍼런스(참조변수)로 자식객체를 다루는 경우
		Avante c2 = new Avante("black","diesel",2022);
		c2.drive();
		c2.moveAvante();
		
		// 3. 부모타입 레퍼런스(참조변수)로 자식객체를 다루는 경우 - 업캐스팅
		Car c3 = c2;
		c3.drive();
		((Car)c2).drive();
		
		Car c4 =new Sonata("white","gas",2023);
		c4.drive();
		Sonata c5 = (Sonata)c4;
		c5.moveSonata();
		
		/*
		 * "상속 구조"의 클래스들 간에 형변환 가능
		 * 
		 * 1.업캐스팅( UpCasting )
		 * 	  자식 타입 -> 부모 타입으로 형변환
		 * 	  자동형변환
		 * 	  ex) 자식.부모메소드();
		 * 		  Car c1 = new Sonata();
		 * 
		 * 
		 * 2.다운캐스팅( DownCasting)
		 * 	  부모 타입 - > 자식 타입으로 형변환
		 * 	  강제형변환 해야한다
		 *    ex) ((자식타입)부모).자식메소드();
		 *        ((Sonata)c1).moveSonata();
		 *        
		 * 다형성
		 * 부모 타입으로부터 파생된 여러가지 타입의 자식 객체들을 부모클래스 타입 하나로 다룰수 있는 기술
		 */
		
		 // 다형성의 장점
		
		 // 다형성 사용 전
		Sonata[] sonataArr = new Sonata[5];
		sonataArr[0] = new Sonata("white", "gas", 2023);
		Avante[] avanteArr = new Avante[5];
		avanteArr[0] = new Avante("black","diesel",2022);
	
		 // 다형성 사용 후
		Car[] carArr = new Car[4];
		carArr[0] = new Sonata("white","gas",2023);
		carArr[1] = new Avante("black","diesel",2022);
		carArr[2] = new Sonata("white","gas",2023);
		carArr[3] = new Avante("black","diesel",2022);
		
		for(int i=0; i<carArr.length; i++) {
			if(carArr[i] instanceof Sonata) {
				((Sonata)carArr[i]).moveSonata();
			}
			else if(carArr[i] instanceof Avante) {
				((Avante)carArr[i]).moveAvante();
			}
			else {
				carArr[i].drive();
			}
		}

	}
}
