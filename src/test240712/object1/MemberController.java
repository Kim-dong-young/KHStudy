package test240712.object1;

public class MemberController {
	public static final int SIZE = 10;
	private Member[] m = new Member[SIZE];
	
	public int existMemberNum() {
		int count=0;
		
		for(Member member : m) {
			if(member != null) count++;
		}
		
		return count;
	}
	
	public boolean checkId(String inputId) {
		boolean isFound = false;
		
		for(Member member : m) {
			if(member != null && member.getId().equals(inputId)) {
				isFound = true;
				break;
			}
		}
		
		return isFound;
	}
	
	public void insertMember(String id, String name, String password, String email, String gender, int age) {
		for(int i=0; i<m.length; i++) {
			if(m[i] == null) {
				m[i] = new Member(id,name,password,email,gender.toCharArray()[0],age);
				break;
			}
		}
	}
	
	public String searchId(String id) {
		String memberInfo = null;
		
		for(Member member : m) {
			if(member != null && member.getId().equals(id))
				memberInfo = member.inform();
		}
		
		return memberInfo;
	}
	
	public Member[] searchName(String name) {
		Member[] matchMembers = new Member[MemberController.SIZE];
		int index = 0;
		
		for(Member member : m) {
			if(member != null && member.getName().equals(name))
				matchMembers[index++] = member; 
		}

		return matchMembers;
	}
	
	public Member[] searchEmail(String email) {
		Member[] matchMembers = new Member[MemberController.SIZE];
		int index = 0;
		
		for(Member member : m) {
			if(member != null && member.getEmail().equals(email))
				matchMembers[index++] = member; 
		}

		return matchMembers;
	}
	
	public boolean updatePassword(String id, String password) {
		boolean isFound = false;
		
		for(Member member:m) {
			if(member != null && member.getId().equals(id)) {
				isFound = true;
				member.setPassword(password);
			}
		}
		return isFound;
	}
	
	public boolean updateName(String id, String name) {
		boolean isFound = false;
		
		for(Member member:m) {
			if(member != null && member.getId().equals(id)) {
				isFound = true;
				member.setName(name);;
			}
		}
		return isFound;
	}
	
	public boolean updateEmail(String id, String email) {
		boolean isFound = false;
		
		for(Member member:m) {
			if(member != null && member.getId().equals(id)) {
				isFound = true;
				member.setEmail(email);;
			}
		}
		return isFound;
	}
	
	public boolean delete(String id) {
		boolean isFound = false;
		int i=0;
		
		for(i=0; i< MemberController.SIZE; i++) {
			if(m[i] != null && m[i].getId().equals(id)) {
				isFound = true;
				break;
			}
		}
		
		if(isFound)
			for(int j=i; j< MemberController.SIZE; j++) {
				try {
					m[j] = m[j+1];
				} catch(IndexOutOfBoundsException e) { // 삭제할 유저가 배열의 맨 끝일 경우
					m[j] = null;
				}
			}
		
		return isFound;
	}
	
	public void delete() {
		m = new Member[SIZE];
	}
	
	public Member[] printAll() {
		return m;
	}
	
}
