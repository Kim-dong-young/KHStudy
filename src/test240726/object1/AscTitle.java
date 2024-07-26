package test240726.object1;

import java.util.Comparator;

public class AscTitle implements Comparator{

	@Override
	public int compare(Object o1, Object o2) {
		Music m1 = (Music)o1;
		Music m2 = (Music)o2;
		
		if(m1.getTitle().equals(m2.getTitle())) {
			// compareTo -> 나 자신과 비교해서 크면 1, 작으면 -1, 동일하면 0
			return m1.getSinger().compareTo(m2.getSinger());
		}
		else {
			return m1.getTitle().compareTo(m2.getTitle());
		}
	}
}
