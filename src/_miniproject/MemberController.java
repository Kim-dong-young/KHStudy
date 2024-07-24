package _miniproject;

import java.util.HashMap;

public class MemberController {
	private HashMap<String, Member> memberList;
	private Member currentMember;
	
	public MemberController() {
		super();
		this.memberList = new HashMap<String, Member>();
	}

	public boolean isMemberExist(String id) {
		return this.memberList.containsKey(id);
	}
	
	public boolean isLoginSuccess(String id, String pwd) {
		boolean success = false;
		Member m = memberList.get(id);
		if(m != null && m.getMemberPwd().equals(pwd))
			success = true;
		return success;
	}
	
	public void loginMember(String id) {
		// id를 입력받아, 해당 id에 속하는 멤버를 currentMember로 설정한다.
		this.currentMember = memberList.get(id);
	}
	
	public Member getCurrentMember() {
		return this.currentMember;
	}
	
	public void addMember(String name, String id, String pwd) {
		this.memberList.put(id, new Member(name,id,pwd));
	}
	
	public void delMember(String id) {
		this.memberList.remove(id);
	}
	
	public void updateMember(String name, String id, String pwd) {
		
	}
	
	public void findMember(String id) {
		
	}
	
	public void showMemberList() {
		
	}
}