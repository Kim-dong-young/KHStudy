package _miniproject.vo;

import java.util.Date;
import java.util.Objects;

public class Comment {
	private int bulletinID; // 댓글이 작성된 게시글 번호
	private int commentID; // 댓글 번호
	private Date writeDate; // 댓글 작성일
	
	private String authorID; // 댓글 작성자 id
	private String content; // 댓글 내용

	public Comment(int bulletinID, int commentID, Date writeDate, String authorID, String content) {
		super();
		this.bulletinID = bulletinID;
		this.commentID = commentID;
		this.writeDate = writeDate;
		this.authorID = authorID;
		this.content = content;
	}
	
	public int getBulletinID() {
		return bulletinID;
	}
	public void setBulletinID(int bulletinID) {
		this.bulletinID = bulletinID;
	}
	public int getCommentID() {
		return commentID;
	}
	public void setCommentID(int commentID) {
		this.commentID = commentID;
	}
	public Date getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}
	public String getAuthorID() {
		return authorID;
	}
	public void setAuthorID(String authorID) {
		this.authorID = authorID;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return Objects.hash(bulletinID, commentID);
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Comment) {
			Comment other = (Comment) obj;
			if(this.bulletinID == other.getBulletinID() &&
			   this.commentID == other.getCommentID() ) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String toString() {
		return String.format("작성자 : %s | 작성일 : %s\n내용 : %s", authorID, writeDate.toString(), content);
	}

}
