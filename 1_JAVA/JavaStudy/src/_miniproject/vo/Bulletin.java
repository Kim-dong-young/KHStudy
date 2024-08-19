package _miniproject.vo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public class Bulletin {
	private int bulletinID;
	private int viewCount;
	private Date writeDate;
	
	private String authorID;
	private String title;
	private String content;
	
	private ArrayList<Comment> comments;

	public Bulletin(int bulletinID, String authorID, String title, String content) {
		super();
		this.bulletinID = bulletinID;
		this.authorID = authorID;
		this.title = title;
		this.content = content;
		this.viewCount = 0;
		this.writeDate = new Date();
		this.comments = new ArrayList<Comment>();
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

	public Date getWriteDate() {
		return writeDate;
	}

	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}
	
	public ArrayList<Comment> getComments() {
		return comments;
	}
	
	public void setComments(ArrayList<Comment> comments) {
		this.comments = comments;
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
		return String.format("게시글 번호 : %d | 제목 : %s | 작성자 : %s | 조회수 : %d | 작성일 : %s",
								bulletinID, title, authorID, viewCount, writeDate.toString());
	}

}
