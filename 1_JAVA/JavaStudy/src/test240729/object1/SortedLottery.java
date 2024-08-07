package test240729.object1;

import java.util.Comparator;

public class SortedLottery implements Comparator<Lottery>{

	@Override
	public int compare(Lottery o1, Lottery o2) {
		/*
		 * compareTo() 의 반환값
		 * A.compareTo(B)
		 * A가 B보다 작다 => 음수
		 * A와 B가 같다 => 0
		 * A가 B보다 크다 => 양수
		 */
		
		int num = o1.getName().compareTo(o2.getName());
		if(num == 0) {
			return o1.getPhone().compareTo(o2.getPhone());
		}
		return num;
	}
}
