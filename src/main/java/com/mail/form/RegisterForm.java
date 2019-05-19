package com.mail.form;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.mail.annotations.Password;
import com.mail.annotations.Username;

public class RegisterForm implements Serializable {
	private static final long serialVersionUID = 5435915727575263107L;

	@NotBlank
	private String firstName; 
	@NotBlank
	private String lastName;
	@NotBlank
	private String gender;
	@NotBlank
	private String dob;
	@NotBlank
	@Username
	private String username;
	@NotBlank
	@Password
	private String password;
	@NotBlank
	private String rePassword;
	@NotBlank
	@Email
	private String emailAddress;

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRePassword() {
		return rePassword;
	}

	public void setRePassword(String rePassword) {
		this.rePassword = rePassword;
	}
}
