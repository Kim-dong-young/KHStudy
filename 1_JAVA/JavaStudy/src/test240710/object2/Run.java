package test240710.object2;

public class Run {

	public static void main(String[] args) {
		Employee employee = new Employee();
		
		employee.setEmpNo(100);
		employee.setEmpName("홍길동");
		employee.setDept("영업부");
		employee.setJob("과장");
		employee.setAge(25);
		employee.setGender('남');
		employee.setSalary(2500000);
		employee.setBonusPoint(.05);
		employee.setPhone("010-1234-5678");
		employee.setAddress("서울시 강남구");
		
		System.out.println("사원번호 : "+ employee.getEmpNo());
		System.out.println("이름: "+ employee.getEmpName());
		System.out.println("부서 : "+ employee.getDept());
		System.out.println("직책 : "+ employee.getJob());
		System.out.println("나이 : "+ employee.getAge());
		System.out.println("성별 : "+ employee.getGender());
		System.out.println("월급 : "+ employee.getSalary());
		System.out.println("인센티브 : "+ employee.getBonusPoint());
		System.out.println("전화번호 : "+ employee.getPhone());
		System.out.println("주소 : "+ employee.getAddress());

	}

}
