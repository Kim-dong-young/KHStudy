package com.kh.board.service;

import static com.kh.common.JDBCTemplate.close;
import static com.kh.common.JDBCTemplate.commit;
import static com.kh.common.JDBCTemplate.getConnection;
import static com.kh.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.board.model.dao.BoardDao;
import com.kh.board.model.vo.Attachment;
import com.kh.board.model.vo.Board;
import com.kh.board.model.vo.Category;
import com.kh.common.PageInfo;

public class BoardService {

	public int selectListCount() {
		Connection conn = getConnection();
		int listCount = new BoardDao().selectListCount(conn);
		
		close(conn);
		return listCount;
	}

	public ArrayList<Board> selectList(PageInfo pi) {
		Connection conn = getConnection();
		ArrayList<Board> list = new BoardDao().selectList(conn, pi);
		
		close(conn);
		return list;
	}
	
	public Board selectBoard(int boardNo) {
		Connection conn = getConnection();
		Board b = new BoardDao().selectBoard(conn, boardNo);

		close(conn);
		return b;
	}

	public Board increaseCount(int boardNo) {
		Connection conn = getConnection();
		BoardDao bDao = new BoardDao();
		
		int result = bDao.increaseCount(conn, boardNo);
		
		Board b = null;
		if(result > 0) {
			commit(conn);
			b = bDao.selectBoard(conn,boardNo);
		} else {
			rollback(conn);
		}
		
		close(conn);
		return b;
	}
	
	public Attachment selectAttachment(int boardNo) {
		Connection conn = getConnection();
		Attachment at = new BoardDao().selectAttachment(conn, boardNo);
		
		close(conn);
		return at;
	}

	public ArrayList<Category> selectCategoryList() {
		Connection conn = getConnection();
		ArrayList<Category> list = new BoardDao().selectCategoryList(conn);
		
		close(conn);
		return list;
	}

	public int insertBoard(Board b, Attachment at) {
		Connection conn = getConnection();
		BoardDao bDao = new BoardDao();
		
		int result1 = bDao.insertBoard(conn,b);
		int result2 = 1; // 디폴트값 성공값 => 파일을 안올렸는데 안올라 갔으면 성공이자나
		if(at != null) {
			result2 = bDao.insertAttachment(conn, at);
		}
		
		if(result1 > 0 && result2 > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		return result1 * result2; // 둘다 성공해야 0이 없어 1 이상이 나온다
	}

	public int updateBoard(Board b, Attachment at) {
		Connection conn = getConnection();
		BoardDao bDao = new BoardDao();
		
		int result1 = bDao.updateBoard(conn,b);
		int result2 = 1;
		if(at != null) { // 첨부파일이 있을 때
			// 기존첨부파일 있을 때 -> update
			if(at.getFileNo() != 0) {
				result2 = bDao.updateAttachment(conn,at);
			}
			// 기존첨부파일 없을 때 -> insert
			else {
				result2 = bDao.insertNewAttachment(conn, at);
			}
		}
		
		if(result1 > 0 && result2 > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		return result1 * result2;
	}

	public ArrayList<Board> selectThumbnailList() {
		Connection conn = getConnection();
		ArrayList<Board> list = new BoardDao().selectThumbnailList(conn);
		
		close(conn);
		return list;
	}

	public int insertThumbnailBoard(Board b, ArrayList<Attachment> list) {
		Connection conn = getConnection();
		
		BoardDao bDao = new BoardDao();
		int result1 = bDao.insertThumbnailBoard(conn, b);
		int result2 = bDao.insertAttachmentList(conn, list);
		
		if(result1 > 0 && result2 > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		return result1 * result2;
	}
	
	public ArrayList<Attachment> selectAttachmentList(int boardNo) {
		Connection conn = getConnection();
		ArrayList<Attachment> atList = new BoardDao().selectAttachmentList(conn, boardNo);
		
		close(conn);
		return atList;
	}
	
}
