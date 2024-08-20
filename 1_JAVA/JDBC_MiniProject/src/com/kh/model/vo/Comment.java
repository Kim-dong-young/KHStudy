package com.kh.model.vo;

import java.sql.Date;
import java.util.Objects;

public class Comment {
	private int bulletinId;
	private int commentId;
	private Date writeDate;
	private int memberUid;
	private String content;
	private boolean isDelete;
	
	public Comment() {
		super();
	}

	public Comment(int memberUid, String content) {
		super();
		this.memberUid = memberUid;
		this.content = content;
	}

	public Comment(int bulletinId, int commentId, Date writeDate, int memberUid, String content, boolean isDelete) {
		super();
		this.bulletinId = bulletinId;
		this.commentId = commentId;
		this.writeDate = writeDate;
		this.memberUid = memberUid;
		this.content = content;
		this.isDelete = isDelete;
	}

	/**
	 * @return the bulletinId
	 */
	public int getBulletinId() {
		return bulletinId;
	}

	/**
	 * @param bulletinId the bulletinId to set
	 */
	public void setBulletinId(int bulletinId) {
		this.bulletinId = bulletinId;
	}

	/**
	 * @return the commentId
	 */
	public int getCommentId() {
		return commentId;
	}

	/**
	 * @param commentId the commentId to set
	 */
	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}

	/**
	 * @return the writeDate
	 */
	public Date getWriteDate() {
		return writeDate;
	}

	/**
	 * @param writeDate the writeDate to set
	 */
	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}

	/**
	 * @return the memberUid
	 */
	public int getMemberUid() {
		return memberUid;
	}

	/**
	 * @param memberUid the memberUid to set
	 */
	public void setMemberUid(int memberUid) {
		this.memberUid = memberUid;
	}

	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * @return the isDelete
	 */
	public boolean isDelete() {
		return isDelete;
	}

	/**
	 * @param isDelete the isDelete to set
	 */
	public void setDelete(boolean isDelete) {
		this.isDelete = isDelete;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return Objects.hash(bulletinId, commentId);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Comment) {
			Comment other = (Comment) obj;
			if (other.getBulletinId() == this.bulletinId && 
				other.getCommentId() == this.commentId)
				return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return "Comment [bulletinId=" + bulletinId + ", commentId=" + commentId + ", writeDate=" + writeDate
				+ ", memberUid=" + memberUid + ", content=" + content + ", isDelete=" + isDelete + "]";
	}
	
	
}
