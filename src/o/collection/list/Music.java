package o.collection.list;

import java.util.Objects;

public class Music {
	private String title;
	private String artist;
	
	public Music() {
		super();
	}
	public Music(String title, String artist) {
		super();
		this.title = title;
		this.artist = artist;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	
	@Override
	public String toString() {
		return "Music [title=" + title + ", artist=" + artist + "]\n";
	}
	@Override
	public int hashCode() {
		return Objects.hash(title,artist);
	}
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Music) {
			Music other = (Music)obj;
			if(other.getTitle().equals(this.title) &&
					other.getArtist().equals(this.artist))
				return true;
		}
		return false;
	}
	
	
	
}
