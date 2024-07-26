package o.collection.list;

import java.util.ArrayList;
import java.util.List;

public class ListRun {
	/*
	 * 컬렉션이란
	 * 자료구조 개념이 내장되어있는 클래스로 자바에서 제공하는 "자료구조"를 담당하는 "프레임워크"이다
	 * - 자료구조 : 방대한 데이터를 보다 호율적으로 관리(추가, 삭제, 조회, 정렬, 수정)할 수 있도록 도와주는 개념
	 * - 프레임워크 : 이미 만들어져 있는 틀(코드 더미)
	 * 		=> 라이브러리와 프레임워크의 차이 : 코드의 제어권이 나에게 있는가? 라이브러리 O / 프레임워크 X
	 * 
	 * * 배열의 단점과 컬렉션의 장점
	 * 
	 * > 배열의 단점
	 * 		1. 배열은 크기를 지정해야 한다.
	 * 		   새로운 값을 더 추가하고자 한다면, 새로운 크기의 배열을 만들고 
	 * 		   기존의 값을 전부 복사하는 코드를 작성해야한다
	 * 
	 * 		2. 배열 중간에 값을 추가하거나 삭제하는 경우, 
	 * 		   값을 매번 이동시켜주는 복잡한 코드를 직접 작성해야 한다
	 * 
	 * 		3. 한 공간에 한 타입의 데이터들만 저장이 가능하다.
	 * 
	 * > 컬렉션의 장점
	 * 		1. 크기를 지정해 줄 필요가 없음!! 
	 * 		   만일 지정했다고 해도 더 많은 데이터들을 담으면 알아서 사이즈를 늘려준다.
	 * 
	 * 		2. 중간에 값을 추가한다거나 삭제하는 경우, 
	 * 		   값을 당겨주는 작업(알고리즘)을 직접 기술할 필요가 없다.
	 * 
	 * 		3. 한 공간에 여러타입의 데이터들을 저장할 수 있다.( 단, 객체만 가능 )
	 * 		   한 타입만 담도록 제한할 수도 있음(제네릭 사용 가능)
	 */

	public static void main(String[] args) {
	//	ArrayList list도 가능, 제네릭은 자유롭게 설정하면 된다. ( 안해도 됨 )
		List list = new ArrayList(3); // 크기지정을 할 수도 있고, 안 해도 괜찮다.
		
		System.out.println(list); // 비어있는 상태
		
		// 1. add(E e) : 리스트 공간 끝에 전달된 데이터를 추가시켜주는 메소드
		list.add(new Music("Industry Baby","Lil Nas X"));
		list.add(new Music("Deja vu","Moona Hoshinova"));
		list.add(new Music("Boyfriend","Big Time Rush"));
		list.add("끝\n");
		
		// 지정된 크기보다 더 많이 넣어도 오류가 발생하지 않는다. -> 장점1. 크기제약 X
		// 다양한 타입의 데이터를 담을 수 있음 -> 장점3. 여러 타입 보관 가능
		
		System.out.println(list); // list의 특징 : 순서 유지하면서 담김( 0번 인덱스부터 차곡차곡 )	

		// 2. add(int index, E e) : 직접 인덱스를 지정해서 해당 위치에 데이터를 추가할 수 있다.
		list.add(1, new Music("Next Episode","Snoop Dogg"));
		System.out.println(list);
		
		// 3. remove(int index) : 해당 인덱스 위치의 데이터를 삭제시켜주는 메소드
		list.remove(1);
		System.out.println(list);
		
		// 4. set(int index, E e) : 해당 인덱스 위치의 값을 전달받은 e 객체로 변경
		list.set(2, new Music("Cake by the ocean", "DNCE"));
		System.out.println(list);
		
		// 5. size() : 리스트의 사용중인 사이즈를 반환시켜주는 메소드
		System.out.println(list.size());
		
		// 6. get(int index) : 해당 인덱스위의 객체 반환시켜주는 메소드
		Music m = (Music) list.get(0);
		System.out.println(m);
		
		// 7. subList(int index1, int index2) : List -> 특정부분 추출해서 새로운 List로 변환
		List sub = list.subList(1, 3); // 1 ~ 2 까지 ( index2 전 까지 )
		System.out.println(sub);
		
		// 8. addAll(Collection c) : 컬렉션을 통째로 뒤에 추가시켜주는 메소드
		list.addAll(sub);
		System.out.println(list);
		
		// 9. isEmpty() : boolean -> 컬렉션이 비어있는지 묻는 메소드
		System.out.println(list.isEmpty());
		
		// 10. clear() : 전부 비워주는 메소드
		// list.clear();
		// System.out.println(list.isEmpty());
		
		// 전체 접근 방법
		System.out.println("===== 전체 접근(for) =====");
		for(int i=0; i< list.size(); i++) {
			System.out.print(list.get(i));
		}
		System.out.println("===== 전체 접근(for-each) =====");
		for(Object o : list) {
			System.out.print(o);
		}

	}

}
