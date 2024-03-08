package com.model;

public class MemberDTO {
	private String id; 
	private String pw; 
	private String nick; 
	private String phone;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public MemberDTO(String id, String pw, String nick, String phone) {
		super();
		this.id = id;
		this.pw = pw;
		this.nick = nick;
		this.phone = phone;
	}
	
	
	// 로그인 생성자 
	public MemberDTO(String id, String pw) {
		super();
		this.id = id;
		this.pw = pw;
	}
	
	
	@Override
	public String toString() {
		return "MemberDTO [id=" + id + ", pw=" + pw + ", nick=" + nick + ", phone=" + phone + "]";
	} 
	
	
	
}
