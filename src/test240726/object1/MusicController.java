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
		
		for(Object music : list) {
			if( ((Music)music).getTitle().equals(title)) {
				String songName = ((Music)music).getTitle();
				String singer = ((Music)music).getSinger();
				list.remove(((Music)music));
				return new Music(songName,singer);
			}
		}
		
		return null;
	}
	
	public Music setMusic(String title, Music music) {
		
		for(Object searchMusic : list) {
			if( ((Music)searchMusic).getTitle().equals(title)) {
				list.add(list.indexOf(searchMusic),music);
				list.remove(searchMusic);
				return ((Music)searchMusic);
			}
		}
		
		return null;
	}
	
	public int ascTitle() {
		// Collections.sort : 컬렉션에서 정렬기능을 제공하는 메소드
		// 정렬하고 싶은 컬렉션 객체 + 정렬 기준을 정한 객체( Comparator 구현된 겍체 ) 를
		// 전달하면 정렬 기준에 맞춰 정렬을 수행해준다.
		try {
			list.sort(new AscTitle());
			return 1;
		} catch(Exception e) {
			return -1;
		}
	}
	
	public int descSinger() {
		try {
			list.sort(new Comparator() {
				@Override
				public int compare(Object o1, Object o2) {
					Music m1 = (Music)o1;
					Music m2 = (Music)o2;

					return m2.getSinger().compareTo(m1.getSinger());
				}
			});;
			return 1;
		} catch(Exception e) {
			return -1;
		}
	}
}
