package com.waiyanhtet.assignment.domain;

public class Registration {

	private int id;
	private OpenClass openClass;
	private String student;
	private String phone;
	private String email;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public OpenClass getOpenClass() {
		return openClass;
	}

	public void setOpenClass(OpenClass openClass) {
		this.openClass = openClass;
	}

	public String getStudent() {
		return student;
	}

	public void setStudent(String student) {
		this.student = student;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Registration [id=" + id + ", openClass=" + openClass + ", student=" + student + ", phone=" + phone
				+ ", email=" + email + "]";
	}

}