package test240717.object2;

public class LibraryController {
	private Member mem = null;
	private Book[] bList = new Book[5];
	
	public LibraryController() {
		bList[0] = new CookBook("백종원의 집밥", "백종원", "tvN", true);
		bList[1] = new AniBook("한번 더 해요", "미티", "원모어", 19);
		bList[2] = new AniBook("루피의 원피스", "루피", "japan", 12);
		bList[3] = new CookBook("이혜정의 얼마나 맛있게요", "이혜정", "문학", false);
		bList[4] = new CookBook("최현석 날 따라해봐", "최현석", "소금책", true);
	}
	
	public void insertMember(Member mem) {
		this.mem = mem;
	}
	
	public Member myInfo() {
		return this.mem;
	}
	
	public Book[] selectAll() {
		return bList;
	}
	
	public Book[] searchBook(String keyword) {
		/*
		// 문자열에 특정 문자가 포함되어 있는지 검사하는 방법
		
		// 1.
		// String의 indexOf("문자열")을 사용해보자
		// int num = "안녕하세요 최지원입니다.".indexOf("최지원");
		// -> 최지원이 들어간 곳은 6번째 인덱스 부터이므로 6 반환 ( 못 찾으면 -1 반환 )
		
		// 2.
		// 문자열.contains("찾고자 하는 문자") => 찾고자 하는 문자가 포함되어있는지
		// "안녕하세요 최지원입니다.".contains("하세") 
		// -> 하세 가 포함되어있으므로 true 반환, 없으면 false
		
		// 3. 이외에 정규식도 있따
		 */
		Book[] foundBooks = new Book[5];
		
		int count=0;
		for(Book book : bList) {
			if(book.getTitle().indexOf(keyword) != -1) {
				foundBooks[count++] = book;
			}
		}
		return foundBooks;
	}
	
	public int rentBook(int index) {
		int result = 0;
		
		if(bList[index] instanceof AniBook) 
			result = ((AniBook)bList[index]).getAccessAge() > this.mem.getAge() ? 1 : 0;
		else if(bList[index] instanceof CookBook)
			if( ((CookBook)bList[index]).isCoupon() ){
				mem.setCouponCount(mem.getCouponCount() + 1);
				result = 2;
			}
			
		return result;
	}
}
