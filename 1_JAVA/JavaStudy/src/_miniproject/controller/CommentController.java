package _miniproject.controller;

import java.util.ArrayList;

import _miniproject.vo.Bulletin;
import _miniproject.vo.Comment;

public class CommentController {
	private static CommentController cc;
	private ArrayList<Comment> comments;
	
	private CommentController() {
		super();
	}
	
	public static CommentController getInstance() {
		if(cc == null) {
			cc = new CommentController();
		}
		return cc;
	}
	
	public ArrayList<Comment> getCommentList(Bulletin bl) {
		return bl.getComments();
	}
	
	public void writeComment(Bulletin bl, Comment comment) {
		comments = getCommentList(bl);
		comments.add(comment);
	}
	
	public boolean deleteComment(Bulletin bl, int commentID) {
		comments = getCommentList(bl);
		Comment cmt = comments.get(commentID);
		
		if(!cmt.isDeleted()) {
			cmt.setContent("삭제된 댓글입니다.");
			cmt.setDeleted(true);
			return true;
		} else {
			System.out.println("이미 삭제된 댓글입니다.");
			return false;
		}
	}
	
	public Comment getComment(Bulletin bl, int commentID) {
		comments = getCommentList(bl);
		return comments.get(commentID);
	}
	
	public void readAllComment(Bulletin bl) {
		comments = getCommentList(bl);
		for(Comment cmt : comments) {
			System.out.println(cmt);
		}
	}
	
	public void updateComment(Bulletin bl, Comment comment) {
		comments = getCommentList(bl);
		comments.set(comment.getCommentID(), comment);
	}
	
}
