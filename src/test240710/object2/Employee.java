package test240710.object2;

public class Employee {
	// 변수
	private String empName;
	private String dept;
	private String job;
	private String phone;
	private String address;
	
	private double bonusPoint;
	
	private int empNo;
	private int age;
	private int salary;
	
	private char gender;

	// 생성자
	public Employee() {
		super();
	}
	
	public Employee(String empName, int empNo) {
		super();
		this.empName = empName;
		this.empNo = empNo;
	}
	
	public Employee(String empName, String dept, String job, String phone, String address, double bonusPoint, int empNo,
			int age, int salary, char gender) {
		super();
		this.empName = empName;
		this.dept = dept;
		this.job = job;
		this.phone = phone;
		this.address = address;
		this.bonusPoint = bonusPoint;
		this.empNo = empNo;
		this.age = age;
		this.salary = salary;
		this.gender = gender;
	}

	// 메소드
	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public double getBonusPoint() {
		return bonusPoint;
	}

	public void setBonusPoint(double bonusPoint) {
		this.bonusPoint = bonusPoint;
	}

	public int getEmpNo() {
		return empNo;
	}

	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}
	
}
