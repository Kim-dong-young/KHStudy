package test240726.object1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MusicController {
	private List list = new ArrayList();
	
	public int addList(Music music) {
		try {
			list.add(list.size(), music);
			return 1;
		} catch(OutOfMemoryError e) {
			return -1;
		}
	}
	
	public int addAtZero(Music music) {
		try {
			list.add(0, music);
			return 1;
		} catch(OutOfMemoryError e) {
			return -1;
		}
	}
	
	public List printAll() {
		return list;
	}
	
	public Music searchMusic(String title) {
		
		for(Object music : list) {
			if(((Music)music).getTitle().equals(title)) {
				return (Music)music;
			}
		}
		return null;
	}
	
	public Music removeMusic(String title) {
		Music m = this.searchMusic(title);
		
		if(m != null) {
			list.remove(m);
		}
		
		return m;
	}
	
	public Music setMusic(String title, Music music) {
		Music foundMusic = this.searchMusic(title);

		if( foundMusic != null ) {
			list.set(list.indexOf(foundMusic), music);
		}
		
		return foundMusic;
	}
	
	public int ascTitle() {
		// Collections.sort : 컬렉션에서 정렬기능을 제공하는 메소드
		// 정렬하고 싶은 컬렉션 객체 + 정렬 기준을 정한 객체( Comparator 구현된 겍체 ) 를
		// 전달하면 정렬 기준에 맞춰 정렬을 수행해준다.
		// ex ) Collections.sort( 정렬하고 싶은 컬렉션 객체, new Comparator객체 );
		try {
			// Collections.sort(list, new AscTitle());
			list.sort(new AscTitle());
			return 1;
		} catch(Exception e) {
			return -1;
		}
	}
	
	public int descSinger() {
		try {
			// lambda식
			list.sort((o1, o2) -> ((Music)o2).getSinger().compareTo(((Music)o1).getSinger()));
			/*
			 * 익명 클래스
			list.sort(new Comparator() {
				@Override
				public int compare(Object o1, Object o2) {
					Music m1 = (Music)o1;
					Music m2 = (Music)o2;

					return m2.getSinger().compareTo(m1.getSinger());
				}
			});;
			*/
			return 1;
		} catch(Exception e) {
			return -1;
		}
	}
}
