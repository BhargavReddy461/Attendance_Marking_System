package com.cognizant.attendanceMarking.auth.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.cognizant.attendanceMarking.auth.enums.Roles;
import com.cognizant.attendanceMarking.auth.model.Admin;
import com.cognizant.attendanceMarking.auth.model.User;
import com.cognizant.attendanceMarking.auth.repository.RoleRepository;
import com.cognizant.attendanceMarking.auth.repository.UserRepository;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(Collections.singleton(roleRepository.findByRole(Roles.USER)));
    
        userRepository.save(user);
    }

    @Override
    public User findByEmail(String email) {
    	System.out.println("user service "+userRepository.findByEmail(email));
        return userRepository.findByEmail(email);
    }
    
    @Override
    public User findUser(User resetPassword) {
    	User  user= userRepository.findByEmail(resetPassword.getEmail());
       
       if(user==null) {
    	   return null;
       }
       
       else if(user.getSecurity1().equals(resetPassword.getSecurity1()) && user.getSecurity2().equals(resetPassword.getSecurity2()) ) {
    	   return user;
    	   
       }
       else {
    	   return null;
       }
       
    }
    
    @Override
    public User updateUser(User passwordForm) {
    	 User  user= userRepository.findByEmail(passwordForm.getEmail());
    	 
    	 if(passwordForm.getPassword().equals(passwordForm.getPasswordConfirm())) {
    		 user.setPassword(bCryptPasswordEncoder.encode(passwordForm.getPassword()));
    		 userRepository.save(user);
    		 return user;
    	 }
    	 return null;
    }
    
    @Override
    public User forgotUsername(User forgotUserUsername) {
       List<User>  users= userRepository.findAllActiveUsers();
       User username=null;
       for(User user:users) {
    	   
       if(user.getFirstname().equals(forgotUserUsername.getFirstname()) && user.getSecurity1().equals(forgotUserUsername.getSecurity1()) && user.getSecurity2().equals(forgotUserUsername.getSecurity2()) ) {
    	   
    	  username=user;
    	   
       }
       
    }
       System.out.println(username);
       return username;
       
    }
}
