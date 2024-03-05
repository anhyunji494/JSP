package com;

public class MemberDTO {
	// 회원의 정보(이름, 나이, 연락처, 주소)를 하나로 묶어주기 위한 클래스 
	
	private String name; 
	private int age; 
	private String Phone; 
	private String addr;
	
	
	// 값 확인용 
	@Override
	public String toString() {
		return "MemberDTO [name=" + name + ", age=" + age + ", Phone=" + Phone + ", addr=" + addr + "]";
	}
	
	// getter/setter 메소드 
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
	public String getPhone() {
		return Phone;
	}
	public void setPhone(String phone) {
		Phone = phone;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	
	// 생성자 
	public MemberDTO(String name, int age, String phone, String addr) {
		this.name = name;
		this.age = age;
		this.Phone = phone;
		this.addr = addr;
	}
	
	
	
}
