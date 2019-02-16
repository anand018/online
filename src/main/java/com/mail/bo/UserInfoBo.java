package com.mail.bo;

import java.io.Serializable;

public class UserInfoBo implements Serializable {
	private static final long serialVersionUID = -4260355305115656224L;
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
