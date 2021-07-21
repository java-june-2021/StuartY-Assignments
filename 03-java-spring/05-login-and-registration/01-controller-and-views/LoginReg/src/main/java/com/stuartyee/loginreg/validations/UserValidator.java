package com.stuartyee.loginreg.validations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.stuartyee.loginreg.models.User;
import com.stuartyee.loginreg.repositories.UserRepository;
import com.stuartyee.loginreg.services.UserService;

@Component
public class UserValidator implements Validator {
	@Autowired
	UserService uServ;
    
    // 1
    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }
    
    // 2
    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;
        
        if (!user.getPasswordConfirmation().equals(user.getPassword())) {
            // 3
            errors.rejectValue("passwordConfirmation", "Match", "password does not match SPY");
        }   
        
        if (uServ.findByEmail(user.getEmail()) != null) {
        	errors.rejectValue("email", "Match", "This user already exists");
        }
    }
}

