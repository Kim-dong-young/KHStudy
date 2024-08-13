package _miniproject.vo;

import java.util.Objects;

public class Bulletin {
	private int bulletinID;
	private int viewCount;
	
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
	
	public int getBulletinID() {
		return bulletinID;
	}

	public void setBulletinID(int bulletinID) {
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
	
	public int getViewCount() {
		return viewCount;
	}

	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}

	@Override
	public int hashCode() {
		return Objects.hash(bulletinID);
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Bulletin) {
			Bulletin other = (Bulletin) obj;
			if(other.getBulletinID() == this.getBulletinID())
				return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return String.format("게시글 번호 : %d | 제목 : %s | 작성자 : %s | 조회수 : %d",
								bulletinID, title, authorID, viewCount);
	}

}
