package test240716.object2;

import java.util.Objects;

public class User {
	private String id;
	private String password;
	private String name;
	private int age;
	private char gender;
	private String phone;
	
	public User() {
		super();
	}
	public User(String id, String password, String name, int age, char gender, String phone) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.phone = phone;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return id + " " + password + " " + name + " " + age + " " + gender
				+ " " + phone;
	}

	@Override
	public boolean equals(Object obj) {
		User user = (User)obj;
		return this.id == user.id && 
				this.password == user.password &&
				this.name == user.name && 
				this.age == user.age &&
				this.gender == user.gender && 
				this.phone == user.phone;
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		User copy = new User(id,password,name,age,gender,phone);
		return copy;
	}
	
	
	
	
	
	
}
