package ch08.customer;

import java.time.LocalDate;

public class Customer {
	private String uid;
	private String name;
	private LocalDate regDate;
	private int isDel;
	
	public Customer() {}
	
	public Customer(String uid, String name) {
		super();
		this.uid = uid;
		this.name = name;
	}

	public Customer(String uid, String name, LocalDate regDate, int isDel) {
		super();
		this.uid = uid;
		this.name = name;
		this.regDate = regDate;
		this.isDel = isDel;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getRegDate() {
		return regDate;
	}

	public void setRegDate(LocalDate regDate) {
		this.regDate = regDate;
	}

	public int getIsDel() {
		return isDel;
	}

	public void setIsDel(int isDel) {
		this.isDel = isDel;
	}

	@Override
	public String toString() {
		return "Customer [uid=" + uid + ", name=" + name + ", regDate=" + regDate + ", isDel=" + isDel + "]";
	}
	
	
	

}
