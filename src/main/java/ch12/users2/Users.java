package ch12.users2;

import java.time.LocalDate;

public class Users {
	private String uid,pwd,Uname,email;
	private LocalDate regdate;
	private int isDel;
	
	public Users() {}

	public Users(String uid, String pwd, String uName, String email, LocalDate regdate, int isDel) {
		super();
		this.uid = uid;
		this.pwd = pwd;
		this.Uname = uName;
		this.email = email;
		this.regdate = regdate;
		this.isDel = isDel;
	}
	
	public Users(String uid, String pwd, String uName) {
		super();
		this.uid = uid;
		this.pwd = pwd;
		this.Uname = uName;
	}
	
	public Users(String pwd, String uName) {
		super();
		this.pwd = pwd;
		this.Uname = uName;
	}
	
	public Users(String uid, String pwd, String uName, String email, String regdate, int isDel) {
		super();
		this.uid = uid;
		this.pwd = pwd;
		this.Uname = uName;
		this.email = email;
		this.regdate = LocalDate.parse(regdate);
		this.isDel = isDel;
	}

	public Users(String uid, String pwd, String uName, String email) {
		super();
		this.uid = uid;
		this.pwd = pwd;
		this.Uname = uName;
		this.email = email;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getUname() {
		return Uname;
	}

	public void setUname(String uname) {
		Uname = uname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getRegdate() {
		return regdate;
	}

	public void setRegdate(LocalDate regdate) {
		this.regdate = regdate;
	}

	public int getIsDel() {
		return isDel;
	}

	public void setIsDel(int isDel) {
		this.isDel = isDel;
	}

	@Override
	public String toString() {
		return "Users [uid=" + uid + ", pwd=" + pwd + ", Uname=" + Uname + ", email=" + email + ", regdate=" + regdate
				+ ", isDel=" + isDel + "]";
	}
	
	
	

	
	
	
	
	
	
}
