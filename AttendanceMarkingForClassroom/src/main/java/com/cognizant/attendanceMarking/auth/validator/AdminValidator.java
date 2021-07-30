package com.cognizant.attendanceMarking.auth.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.cognizant.attendanceMarking.auth.model.Admin;
import com.cognizant.attendanceMarking.auth.service.AdminService;
import com.cognizant.attendanceMarking.auth.service.UserService;

@Component
public class AdminValidator implements Validator {
    @Autowired
    private AdminService adminService;
    
    @Autowired
    private UserService userService;

    @Override
    public boolean supports(Class<?> aClass) {
        return Admin.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Admin admin = (Admin) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "NotEmpty");
        if (admin.getEmail().length() < 6 || admin .getEmail().length() > 32) {
            errors.rejectValue("email", "Size.userForm.email");
        }
        if (adminService.findByEmail(admin.getEmail()) != null ||  userService.findByEmail(admin.getEmail()) != null) {
            errors.rejectValue("email", "Duplicate.userForm.email");
        }
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstname", "NotEmpty");
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastname", "NotEmpty");
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "age", "NotEmpty");
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "gender", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "contact", "NotEmpty");
        
        
        

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
        if (admin.getPassword().length() < 8 || admin.getPassword().length() > 32) {
            errors.rejectValue("password", "Size.userForm.password");
        }

        if (!admin.getPasswordConfirm().equals(admin.getPassword())) {
            errors.rejectValue("passwordConfirm", "Diff.userForm.passwordConfirm");
        }
    }
}
