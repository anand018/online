package com.mail.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target(value = ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented 
@Constraint(validatedBy = PasswordValidator.class)
public @interface Password {

	String message() default "weak password";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
