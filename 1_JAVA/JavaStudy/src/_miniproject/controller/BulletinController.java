package _miniproject.controller;

import java.util.ArrayList;

import _miniproject.vo.Bulletin;

public class BulletinController {
	private static BulletinController bc;
	private ArrayList<Bulletin> bulletinList;
	
	private BulletinController() {
		super();
		bulletinList = new ArrayList<Bulletin>();
		
		// 테스트용 데이터
		bulletinList.add(new Bulletin(0,"test1","안녕하세요","반갑습니다1"));
		bulletinList.add(new Bulletin(1,"test2","졸리네요","반갑습니다2"));
		bulletinList.add(new Bulletin(2,"test1","배고파요","반갑습니다3"));
		bulletinList.add(new Bulletin(3,"test1","안녕하세요","반갑습니다4"));
		bulletinList.add(new Bulletin(4,"test2","졸리네요","반갑습니다5"));
		
		bulletinList.add(new Bulletin(5,"test1","안녕하세요","반갑습니다6"));
		bulletinList.add(new Bulletin(6,"test3","안녕하세요","반갑습니다7"));
		bulletinList.add(new Bulletin(7,"test3","졸리네요","반갑습니다8"));
		bulletinList.add(new Bulletin(8,"test1","안녕하세요","반갑습니다9"));
		bulletinList.add(new Bulletin(9,"test4","배고파요","반갑습니다10"));
		
		bulletinList.add(new Bulletin(10,"test2","안녕하세요","반갑습니다11"));
		bulletinList.add(new Bulletin(11,"test4","졸리네요","반갑습니다12"));
		bulletinList.add(new Bulletin(12,"test4","배고파요","반갑습니다13"));
		bulletinList.add(new Bulletin(13,"test1","안녕하세요","반갑습니다14"));
		bulletinList.add(new Bulletin(14,"test5","안녕하세요","반갑습니다15"));
		
		bulletinList.add(new Bulletin(15,"test5","안녕하세요","반갑습니다16"));
		bulletinList.add(new Bulletin(16,"test3","배고파요","반갑습니다17"));
	}
	
	public static BulletinController getInstance() {
		if(bc == null) {
			bc = new BulletinController();
		}
		return bc;
	}
	
	public ArrayList<Bulletin> getBulletinList() {
		return bulletinList;
	}
	
	public ArrayList<Bulletin> getBulletinList(int searchCriterion, String searchText) {
		if(searchCriterion == 1) {
			return searchByTitle(searchText);
		}
		else if (searchCriterion == 2) {
			return searchByAuthor(searchText);
		}
		return null;
	}

	public void setBulletinList(ArrayList<Bulletin> bulletinList) {
		this.bulletinList = bulletinList;
	}

	public void writeBulletin(String id, String title, String content) {
		bulletinList.add(new Bulletin(bulletinList.size(),id,title,content));
	}
	
	public void deleteBulletin(int index) {
		bulletinList.remove(index);
	}
	
	public Bulletin searchByIndex(int index){
		if(index >= 0 && index < bulletinList.size()) {
			return bulletinList.get(index);
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
	
	public void updateBulletin() {
		
	}
	
	
}
