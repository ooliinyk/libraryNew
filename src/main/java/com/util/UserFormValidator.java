package com.util;

import com.entity.User;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


@Component
public class
		UserFormValidator implements Validator {



//	@Override
	public boolean supports(Class<?> paramClass) {
		return User.class.equals(paramClass);
	}

//	@Override
	public void validate(Object obj, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "id", "id.required");

		User user = (User) obj;
		if(user.getId() <=0){
			errors.rejectValue("id", "negativeValue", new Object[]{"'id'"}, "id can't be negative");
		}

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "login", "login.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "roles", "roles.required");
	}
}
