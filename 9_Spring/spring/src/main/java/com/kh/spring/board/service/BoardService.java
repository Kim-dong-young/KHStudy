package com.kh.spring.board.service;

import java.util.ArrayList;

import com.kh.spring.board.model.vo.Board;
import com.kh.spring.common.vo.PageInfo;

public interface BoardService {

	// 게시글 총 갯수 가져오기
	int selectListCount();

	// 게시글 목록 가져오기
	ArrayList<Board> selectList(PageInfo pi);
	
	// 게시글 조회수 증가
	int increaseCount(int boardNo);

	// 게시글 조회
	Board selectBoard(int boardNo);
	
}
