package test240726.object1;

import java.util.Objects;

public class Music {
	private String title;
	private String singer;
	public Music() {
		super();
	}
	public Music(String title, String singer) {
		super();
		this.title = title;
		this.singer = singer;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSinger() {
		return singer;
	}
	public void setSinger(String singer) {
		this.singer = singer;
	}
	
	@Override
	public String toString() {
		return singer + " - " + title;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(singer, title);
	}
	
	@Override
	public boolean equals(Object obj) {
		Music m = (Music)obj;
		if(this.singer.equals(m.getSinger()) &&
				this.title.equals(m.getTitle())) {
			return true;
		}
		else
			return false;
	}
	
	public int compareTo(Object o) {
		Music other = (Music) o;
	    return this.title.compareTo(other.title);
	}
	
}
