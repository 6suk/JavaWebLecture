package ch14.users3;

import java.time.LocalDate;

public class Users {
	private String uid,pwd,uname,email;
	private LocalDate regdate;
	private int isDel;
	
	public Users() {}

	public Users(String uid, String pwd, String uname, String email, LocalDate regdate, int isDel) {
		super();
		this.uid = uid;
		this.pwd = pwd;
		this.uname = uname;
		this.email = email;
		this.regdate = regdate;
		this.isDel = isDel;
	}
	
	public Users(String uid, String pwd, String uname) {
		super();
		this.uid = uid;
		this.pwd = pwd;
		this.uname = uname;
	}
	
	public Users(String pwd, String uname) {
		super();
		this.pwd = pwd;
		this.uname = uname;
	}
	
	public Users(String uid, String pwd, String uname, String email, String regdate, int isDel) {
		super();
		this.uid = uid;
		this.pwd = pwd;
		this.uname = uname;
		this.email = email;
		this.regdate = LocalDate.parse(regdate);
		this.isDel = isDel;
	}

	public Users(String uid, String pwd, String uname, String email) {
		super();
		this.uid = uid;
		this.pwd = pwd;
		this.uname = uname;
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
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
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
		return "Users [uid=" + uid + ", pwd=" + pwd + ", uname=" + uname + ", email=" + email + ", regdate=" + regdate
				+ ", isDel=" + isDel + "]";
	}
	
	
	

	
	
	
	
	
	
}
