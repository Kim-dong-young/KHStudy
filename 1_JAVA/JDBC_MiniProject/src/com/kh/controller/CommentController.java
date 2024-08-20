package com.kh.controller;

public class CommentController {
	private static CommentController cc;
	
	private CommentController() {
		super();
	}
	
	public static CommentController getInstance() {
		if(cc == null)
			cc = new CommentController();
		return cc;
	}
}
