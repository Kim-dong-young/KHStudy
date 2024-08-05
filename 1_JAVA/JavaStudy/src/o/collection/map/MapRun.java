package o.collection.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class MapRun {

	public static void main(String[] args) {
		HashMap hm = new HashMap();
		
		// 계층구조를 보면
		// List계열, Set계열의 클래스들은 Collection을 구현한 클래스이다.
		// => 객체를 추가하고자 할 때, 공통적으로 add 메소드를 이용
		
		// Map계열은 Collection을 구현한 클래스가 아니다
		// => 객체를 추가하고자 할 때, put 메소드를 이용(key + value 한 쌍으로 담아야한다.)
		
		// 1. put(k, v) : map에 키 밸류 세트로 추가시켜주는 메소드
		hm.put("다이제", new Snack("초코맛", 1000));
		hm.put("칸초", new Snack("단맛", 500));
		hm.put("먹태깡", new Snack("짠맛", 600));
		hm.put("아이셔", new Snack("신맛", 300));
		
		// 저장되는 순서 유지 안됨! value값이 중복되어도 키 값이 중복되지 않으면 잘 저장됨
		System.out.println(hm);
		
		// 동일한 키 값으로 다시 추가하는 경우, value값이 덮어씌워진다 ( 중복된 키 값이 공존할 수 없음, 키 값이 식별자 역할 )
		hm.put("먹태깡", new Snack("매운맛",700));
		System.out.println(hm);
		// 키 값의 중복검사는 equals와 hashCode로 이루어진다. 따라서 따로 객체를 key로 삼고 싶다면
		// equals와 hashCode 오버라이딩 하는 것을 잊지말자.
		
		// 2. get(Object key) : 해당 키값을 가지는 value값을 리턴해준다.
		System.out.println(hm.get("다이제"));
		
		// 3. size() : 담겨있는 객체들의 수( key 기준 )
		System.out.println(hm.size());
		
		// 4. replace(key, value) => 해당 키 값을 찾아서 다시 전달한 value값으로 수정
		// put과 차이점은 없으면 수정하지 않는다. 보통 우리가 쓸 땐, 검사한 뒤 사용하니까 put 많이 쓸 것
		hm.replace("먹태깡", new Snack("아주 매운맛",800));
		
		// 5. remove(Object key) => 해당 키 값을 찾아서 그 밸류세트를 삭제시켜주는 메소드
		hm.remove("다이제");
		System.out.println(hm);
		
		
		// 전체객체에 대해서 접근하는 방법
		// Iterator을 상속받지 않음, 반복자 사용 불가능 => for-each 불가능
		
		// Map의 key는 set과 매우 유사하다
		//1. key를 모아서, set 자료구조의 형태로 받을 수 있다.
		Set keySet = hm.keySet();
		System.out.println(keySet);
		
		for(Object key : keySet) {
			System.out.println(key + " " + hm.get(key));
		}
		
		//2. entrySet() 이용하는 방법
		Set entrySet = hm.entrySet();
		Iterator iter = entrySet.iterator();
		
		while(iter.hasNext()) {
			Entry entry = (Entry)iter.next();
			System.out.println((String)entry.getKey() + " " + (Snack)entry.getValue());
		}
		
		
	}

}
