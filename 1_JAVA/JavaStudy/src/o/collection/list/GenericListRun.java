package o.collection.list;

import java.util.LinkedList;
import java.util.List;

public class GenericListRun {
	public static void main(String[] args) {
		List<Music> list = new LinkedList<>();
		
		list.add(new Music("Industry Baby","Lil Nas X"));
		list.add(new Music("Deja vu","Moona Hoshinova"));
		list.add(new Music("Boyfriend","Big Time Rush"));
		// list.add("끝\n"); Generic으로 타입이 제한되었다.
		System.out.println(list);
		
		for(Music m : list) {
			System.out.println(m);
		}
		
		/*
		 * 제네릭을 사용하는 이유
		 * 1. 명시된 타입의 객체만 저장하도록 제한을 둘 수 있다.
		 * 2. 컬렉션에 저장된 객체를 열어서 사용할 때, 매번 형변환 하는 절차를 없애기 위해서
		 */
	}
}
