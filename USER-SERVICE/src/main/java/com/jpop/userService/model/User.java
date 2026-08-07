package com.jpop.userService.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {

	@Id
	private Long id;

	private String name;

	private String email;

	private String mobile;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getfName() {
		return name;
	}

	public void setfName(String fName) {
		this.name = fName;
	}

	public String getEmailId() {
		return email;
	}

	public void setEmailId(String emailId) {
		this.email = emailId;
	}

	public String getMobileNumber() {
		return mobile;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobile = mobileNumber;
	}
}
