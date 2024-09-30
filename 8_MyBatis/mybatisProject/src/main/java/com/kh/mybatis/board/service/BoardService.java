package com.kh.mybatis.board.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.kh.mybatis.board.model.vo.Board;
import com.kh.mybatis.board.model.vo.Reply;
import com.kh.mybatis.common.vo.PageInfo;

public interface BoardService {
	// 게시판 리스트 조회
	public abstract int selectListCount();
	ArrayList<Board> selectList(PageInfo pi);
	
	// 게시글 상세 조회
	public Board increaseCount(int boardNo);
	public abstract ArrayList<Reply> selectReplyList(int boardNo);
	
	// 게시판 리스트 검색 조회
	public abstract int selectSearchCount(HashMap<String, String> map);
	public abstract ArrayList<Board> selectSearchList(HashMap<String, String> map, PageInfo pi);
}
