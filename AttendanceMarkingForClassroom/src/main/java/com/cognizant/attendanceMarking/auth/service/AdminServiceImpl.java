package com.cognizant.attendanceMarking.auth.service;



import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.cognizant.attendanceMarking.auth.enums.Roles;
import com.cognizant.attendanceMarking.auth.model.Admin;
import com.cognizant.attendanceMarking.auth.repository.AdminRepository;
import com.cognizant.attendanceMarking.auth.repository.RoleRepository;


@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminRepository adminRepository;
    
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(Admin admin) {
        admin.setPassword(bCryptPasswordEncoder.encode(admin.getPassword()));
        admin.setRoles(Collections.singleton(roleRepository.findByRole(Roles.ADMIN)));
    
        adminRepository.save(admin);
    }
    @Override
	public List<Admin> getAll() {
		// TODO Auto-generated method stub
		return adminRepository.findAllActiveUsers();
	}
    
    

    @Override
    public Admin findByEmail(String email) {
        return adminRepository.findByEmail(email);
    }
    
    @Override
	public void updateStatus(String adminId) {
		// TODO Auto-generated method stub
		Optional<Admin> admins=adminRepository.findById(Integer.parseInt(adminId));
		Admin admin=admins.get();
		if(admin.getStatus().equals("pending")) {
			admin.setStatus("active");
			
		}else {
			admin.setStatus("pending");
		}
		
		adminRepository.save(admin);
		
	}
    
    @Override
	public void rejectAdmin(int adminId) {
		// TODO Auto-generated method stub
		Optional<Admin> admins=adminRepository.findById(adminId);
		Admin admin=admins.get();
		if(admin.getStatus().equals("pending")) {
			admin.setStatus("rejected");
			
		}
		
		adminRepository.save(admin);
		
	}
    
    @Override
    public Admin findAdmin(Admin resetPassword) {
       Admin  admin= adminRepository.findByEmail(resetPassword.getEmail());
       
       if(admin==null) {
    	   return null;
       }
       
       else if(admin.getSecurity1().equals(resetPassword.getSecurity1()) && admin.getSecurity2().equals(resetPassword.getSecurity2()) ) {
    	   return admin;
    	   
       }
       else {
    	   return null;
       }
       
    }
    
    @Override
    public Admin updateAdmin(Admin passwordForm) {
    	 Admin  admin= adminRepository.findByEmail(passwordForm.getEmail());
    	 
    	 if(passwordForm.getPassword().equals(passwordForm.getPasswordConfirm())) {
    		 admin.setPassword(bCryptPasswordEncoder.encode(passwordForm.getPassword()));
    		 adminRepository.save(admin);
    		 return admin;
    	 }
    	 else {
    	 return null;
    	 }
    }
    
    @Override
    public Admin forgotUsername(Admin forgotUsername) {
       List<Admin>  admins= adminRepository.findAllActiveUsers();
       Admin adminname=null;
       for(Admin admin:admins) {
    	   
       if(admin.getContact().equals(forgotUsername.getContact()) && admin.getSecurity1().equals(forgotUsername.getSecurity1()) && admin.getSecurity2().equals(forgotUsername.getSecurity2()) ) {
    	   
    	  adminname=admin;
    	   
       }
       
    }
       System.out.println(adminname);
       return adminname;
       
    }
    
    @Override
    public void deleteAdminById(int id) {
    	adminRepository.deleteById(id);
    }
}
