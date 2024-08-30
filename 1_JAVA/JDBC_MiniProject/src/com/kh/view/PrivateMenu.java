package com.kh.view;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.kh.controller.MemberController;
import com.kh.model.vo.MemberItem;
import com.kh.model.vo.Share;
import com.kh.model.vo.TradeLog;
import com.kh.model.vo.items.Item;

public class PrivateMenu {
	private Scanner s;
	private MemberController mc;
	
	public PrivateMenu() {
		super();
	}
	
	public PrivateMenu(Scanner s) {
		super();
		this.s = s;
		mc = MemberController.getInstance();
	}
	
	public void mainMenu() {
		int ch = -1;
		
		while(ch != 0) {
			System.out.printf("===== %s 님의 마이페이지 =====\n", mc.getCurrentMember().getMemberName());
			System.out.println("1. 보유중인 주식 확인");
			System.out.println("2. 보유중인 아이템 확인");
			System.out.println("3. 거래 기록 확인");
			System.out.println("0. 뒤로 가기");
			
			try {
				ch = s.nextInt();
			} catch(InputMismatchException e) {
				System.out.println("잘못된 입력입니다.");
				continue;
			} finally {
				s.nextLine();
			}
			
			switch(ch) {
			case 1:
				displayShareHeld(mc.getMemberShareHeld(mc.getCurrentMember()));
				break;
			case 2:
				itemMenu();
				break;
			case 3:
				tradeLogMenu();
				break;
			case 0:
				System.out.println("마이페이지에서 나갑니다.");
				continue;
			default:
				System.out.println("잘못 입력하셨습니다.");
				break;
			}
		}
	}
	
	public void displayShareHeld(ArrayList<Share> shareHeld) {
		if (shareHeld.isEmpty()) {
			System.out.println("보유중인 주식이 없습니다.");
			return;
		}
		
		for(Share sh : shareHeld) {
			System.out.println(sh);
		}
	}
	
	public void displayItemList(ArrayList<Item> itemList) {
		if (itemList.isEmpty()) {
			System.out.println("보유중인 아이템이 없습니다.");
			return;
		}
		
		for(Item it : itemList) {
			System.out.println(it);
		}
	}
	
	public int displayTradeLog(ArrayList<TradeLog> tradeLog) {
		if (tradeLog.isEmpty()) {
			System.out.println("거래 기록이 없습니다.");
		}
		
		for(TradeLog tl : tradeLog) {
			System.out.println(tl);
		}
		return tradeLog.size();
	}
	
	public void itemMenu() {
		int ch = -1;
		
		while(ch != 0) {
			System.out.println("===== 보유중인 아이템 =====");
			displayItemList(mc.getMemberItemList(mc.getCurrentMember()));
			System.out.println("0. 마이페이지로 돌아가기");
			System.out.print("사용할 아이템 번호 : ");
			
			try {
				ch = s.nextInt();
			} catch(InputMismatchException e) {
				System.out.println("잘못된 입력입니다.");
				continue;
			} finally {
				s.nextLine();
			}
			
			
			if(ch == 0) 
				return;
			else
				mc.useItem(new MemberItem(mc.getCurrentMember().getMemberUid(), ch));
		}
		
	}
	
	public void tradeLogMenu() {
		int ch = -1;
		int pageNum = 10;
		// 한번에 end - start + 1 개 거래기록 조회 
		int start = 1; // 가져올 기록 시작 인덱스
		int end = pageNum; // 가져올 기록 끝 인덱스
		
		while(ch != 0) {
			System.out.println("===== 최근 거래 기록 =====");
			int logCount = displayTradeLog(mc.getMemberTradeLog(mc.getCurrentMember(), start, end));
			System.out.println("=======================");
			System.out.println("최신 기록으로 : N / 이전 기록으로 : P 입력");
			System.out.println("뒤로 가기 : Q 입력");
			System.out.print("이동할 페이지 입력 : ");
			String nextPage = s.next().toUpperCase();
			
			// 시작 인덱스가 1 이상인지 검사
			if(nextPage.equals("N") && start - pageNum > 0 ) {
				start -= pageNum;
				end -= pageNum;
			}
			
			// 시작 인덱스가 1 이하면 지금 페이지가 가장 최신
			else if(nextPage.equals("N") && start - pageNum < 0 ) {
				new AlertMenu().tradeLogNotExist();
			}
			
			// 불러온 로그 갯수가 최대 갯수와 같다 = 더 불러올 데이터가 있다고 가정
			else if(nextPage.equals("P") && logCount == pageNum) {
				start += pageNum;
				end += pageNum;
			}
			
			// 불러온 로그 갯수가 최대 갯수와 다름 = 100% 마지막 페이지
			else if(nextPage.equals("P") && logCount != pageNum) {
				new AlertMenu().tradeLogNotExist();
			}
			
			
			else if(nextPage.equals("Q")) {
				return;
			}
			
			else {
				new AlertMenu().inputValueNotValid();
			}
		}
	}
	
}
