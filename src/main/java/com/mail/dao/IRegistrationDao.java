package com.mail.dao;

import java.sql.Timestamp;

import com.mail.bo.RegistrationBo;
import com.mail.bo.RegistrationVerificationBo;

public interface IRegistrationDao {

	public void addUser(RegistrationBo registrationBo);

	public void saveTimeStamp(Timestamp timestamp, String key, String firstName);

	public Timestamp getTimeStamp(String key);

	public void updateUserStatus(RegistrationVerificationBo registrationVerificationBo);

	public boolean checkUserName(String username);

}
