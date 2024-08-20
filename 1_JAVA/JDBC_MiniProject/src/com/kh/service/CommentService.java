package com.kh.service;

public class CommentService {
	private static CommentService cs;
	
	private CommentService() {
		super();
	}
	
	public static CommentService getInstance() {
		if(cs == null)
			cs = new CommentService();
		return cs;
	}
}
