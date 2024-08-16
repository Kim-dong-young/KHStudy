package _miniproject.controller;

import java.util.ArrayList;

import _miniproject.vo.Bulletin;
import _miniproject.vo.Comment;

public class BulletinController {
	private static BulletinController bc;
	private static CommentController cc = CommentController.getInstance();
	private ArrayList<Bulletin> bulletinList;
	private int index;
	
	private BulletinController() {
		super();
		this.bulletinList = new ArrayList<Bulletin>();
		this.index = 1;
		
		// 테스트용 데이터
		writeBulletin("test1","안녕하세요","반갑습니다1");
		writeBulletin("test2","졸리네요","반갑습니다2");
		writeBulletin("test1","배고파요","반갑습니다3");
		writeBulletin("test1","안녕하세요","반갑습니다4");
		writeBulletin("test2","졸리네요","반갑습니다5");
		
		writeBulletin("test1","안녕하세요","반갑습니다6");
		writeBulletin("test3","안녕하세요","반갑습니다7");
		writeBulletin("test3","졸리네요","반갑습니다8");
		writeBulletin("test1","안녕하세요","반갑습니다9");
		writeBulletin("test4","배고파요","반갑습니다10");
		
		writeBulletin("test2","안녕하세요","반갑습니다11");
		writeBulletin("test4","졸리네요","반갑습니다12");
		writeBulletin("test4","배고파요","반갑습니다13");
		writeBulletin("test1","안녕하세요","반갑습니다14");
		writeBulletin("test5","안녕하세요","반갑습니다15");
		
		writeBulletin("test5","안녕하세요","반갑습니다16");
		writeBulletin("test3","배고파요","반갑습니다17");
	}
	
	public static BulletinController getInstance() {
		if(bc == null) {
			bc = new BulletinController();
		}
		return bc;
	}
	
	// 게시글 전체 조회
	public ArrayList<Bulletin> getBulletinList() {
		return bulletinList;
	}
	
	// 게시글 검색 조회
	public ArrayList<Bulletin> getBulletinList(int searchCriterion, String searchText) {
		if(searchCriterion == 1) { // 제목으로 검색
			return searchByTitle(searchText);
		}
		else if (searchCriterion == 2) { // 작성자명으로 검색
			return searchByAuthor(searchText);
		}
		else if(searchCriterion == 0) {
			return bulletinList;
		}
		return null;
	}

	public void setBulletinList(ArrayList<Bulletin> bulletinList) {
		this.bulletinList = bulletinList;
	}

	public void writeBulletin(String id, String title, String content) {
		bulletinList.add(new Bulletin(index++,id,title,content));
	}
	
	public boolean deleteBulletin(Bulletin bl) {
		return bulletinList.remove(bl);
	}
	
	public void addViewCount(Bulletin bl) {
		bl.setViewCount(bl.getViewCount() + 1);
	}
	
	public Bulletin searchByBulletinID(int bulletinID){
		for(Bulletin bl : bulletinList) {
			if(bl.getBulletinID() == bulletinID) {
				return bl;
			}
		}
		return null;
	}
	
	public ArrayList<Bulletin> searchByTitle(String title){
		ArrayList<Bulletin> searchList = new ArrayList<Bulletin>();
		for(Bulletin bl : bulletinList) {
			if(bl.getTitle().contains(title)) {
				searchList.add(bl);
			}
		}
		return searchList;
	}
	
	public ArrayList<Bulletin> searchByAuthor(String author){
		ArrayList<Bulletin> searchList = new ArrayList<Bulletin>();
		for(Bulletin bl : bulletinList) {
			if(bl.getAuthorID().contains(author)) {
				searchList.add(bl);
			}
		}
		return searchList;
	}
	
	public void updateBulletin(Bulletin bl, String title, String content) {
		if(title != null && content != null) {
			bl.setTitle(title);
			bl.setContent(content);
		}
		else if(title != null) {
			bl.setTitle(title);
		}
		else if (content != null) {
			bl.setContent(content);
		}
		else {
			System.out.println("잘못된 수정입니다.");
		}
	}
	
	public void writeComment(Bulletin bl, Comment comment) {
		cc.writeComment(bl, comment);
	}
	
	public void deleteComment(Bulletin bl, int commentID) {
		cc.deleteComment(bl, commentID);
	}
	
	public Comment getComment(Bulletin bl, int commentID) {
		return cc.getComment(bl, commentID);
	}
	
	public void readAllComment(Bulletin bl) {
		cc.readAllComment(bl);
	}
	
	public void updateComment(Bulletin bl, Comment comment, int commentID) {
		cc.updateComment(bl, comment, commentID);
	}
	
}
