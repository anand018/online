package com.mail.annotations;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordValidator implements ConstraintValidator<Password, String> {

	@Override
	public boolean isValid(String password, ConstraintValidatorContext context) {

		if (password.length() < 5)
			return false;
		else {
			Pattern pattern = Pattern.compile("[^A-Za-z0-9 ]");
			Matcher matcher = pattern.matcher(password);
			boolean hasSpecialChars = matcher.find();

			if (!hasSpecialChars)
				return false;
		}
		return true;
	}
}
