package _miniproject.vo;

import java.util.Objects;

public class Bulletin {
	private int bulletinID;
	
	private String authorID;
	private String title;
	private String content;

	public Bulletin(int bulletinID, String authorID, String title, String content) {
		super();
		this.bulletinID = bulletinID;
		this.authorID = authorID;
		this.title = title;
		this.content = content;
	}
	
	public int getbulletinID() {
		return bulletinID;
	}

	public void setbulletinID(int bulletinID) {
		this.bulletinID = bulletinID;
	}

	public String getAuthorID() {
		return authorID;
	}

	public void setAuthorID(String authorID) {
		this.authorID = authorID;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(bulletinID);
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Bulletin) {
			Bulletin other = (Bulletin) obj;
			if(other.getbulletinID() == this.getbulletinID())
				return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return "게시글 번호 : " + bulletinID +  " | 제목 : " + title + " | 작성자 : " + authorID;
	}

}
