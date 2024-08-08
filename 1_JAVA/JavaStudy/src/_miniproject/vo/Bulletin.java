package _miniproject.vo;

import java.util.Objects;

public class Bulletin {
	private int index;
	
	private String authorID;
	private String title;
	private String content;

	public Bulletin(int index, String authorID, String title, String content) {
		super();
		this.index = index;
		this.authorID = authorID;
		this.title = title;
		this.content = content;
	}
	
	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
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
		return Objects.hash(index);
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Bulletin) {
			Bulletin other = (Bulletin) obj;
			if(other.getIndex() == this.getIndex())
				return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return "게시글 번호 : " + index +  " | 제목 : " + title + " | 작성자 : " + authorID;
	}

}
