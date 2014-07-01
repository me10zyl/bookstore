package net.vicp.zyl_me.model;

public class UserBean {
	private long userid;
	private String username;
	private String password_;
	private int grade;
	private String truename;
	private String email;
	private String phone;
	private String address_;

	public UserBean(long userid, String username, String password_, int grade, String truename, String email, String phone, String address_) {
		super();
		this.userid = userid;
		this.username = username;
		this.password_ = password_;
		this.grade = grade;
		this.truename = truename;
		this.email = email;
		this.phone = phone;
		this.address_ = address_;
	}

	public String getAddress_() {
		return address_;
	}

	public String getEmail() {
		return email;
	}

	public int getGrade() {
		return grade;
	}

	public String getPassword_() {
		return password_;
	}

	public String getPhone() {
		return phone;
	}

	public String getTruename() {
		return truename;
	}

	public long getUserid() {
		return userid;
	}

	public String getUsername() {
		return username;
	}

	public void setAddress_(String address_) {
		this.address_ = address_;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public void setPassword_(String password_) {
		this.password_ = password_;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setTruename(String truename) {
		this.truename = truename;
	}

	public void setUserid(long userid) {
		this.userid = userid;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}
