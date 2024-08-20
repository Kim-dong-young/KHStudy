package com.kh.model.dao;

public class CommentDao {
	private static CommentDao cd;
	
	private CommentDao() {
		super();
	}
	
	public static CommentDao getInstance() {
		if(cd == null)
			cd = new CommentDao();
		return cd;
	}
}
