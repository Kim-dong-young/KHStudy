package com.kh.model.vo;

import java.sql.Date;
import java.util.Objects;

public class Bulletin {
	private int bulletinId;
	private int viewCount;
	private Date writeDate;
	private int memberUid;
	private String title;
	private String content;
	private boolean isDelete;
	
	public Bulletin() {
		super();
	}

	public Bulletin(int memberUid, String title, String content) {
		super();
		this.memberUid = memberUid;
		this.title = title;
		this.content = content;
	}

	public Bulletin(int bulletinId, int viewCount, Date writeDate, int memberUid, String title, String content,
			boolean isDelete) {
		super();
		this.bulletinId = bulletinId;
		this.viewCount = viewCount;
		this.writeDate = writeDate;
		this.memberUid = memberUid;
		this.title = title;
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
	 * @return the viewCount
	 */
	public int getViewCount() {
		return viewCount;
	}

	/**
	 * @param viewCount the viewCount to set
	 */
	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
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
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
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
		return Objects.hash(bulletinId);
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Bulletin) {
			Bulletin other = (Bulletin)obj;
			if(other.getBulletinId() == this.bulletinId)
				return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return "Bulletin [bulletinId=" + bulletinId + ", viewCount=" + viewCount + ", writeDate=" + writeDate
				+ ", memberUid=" + memberUid + ", title=" + title + ", content=" + content + ", isDelete=" + isDelete
				+ "]";
	}	
	
}
