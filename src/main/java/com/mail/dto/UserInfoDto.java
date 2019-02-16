package com.mail.dto;

import java.io.Serializable;

public class UserInfoDto implements Serializable {
	private static final long serialVersionUID = 7624727840814953628L;
	private String firstName;
	private String joiningYear;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getJoiningYear() {
		return joiningYear;
	}

	public void setJoiningYear(String joiningYear) {
		this.joiningYear = joiningYear;
	}
}
