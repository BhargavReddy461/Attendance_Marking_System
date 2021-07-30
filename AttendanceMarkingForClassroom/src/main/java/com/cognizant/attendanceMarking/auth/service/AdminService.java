package com.cognizant.attendanceMarking.auth.service;

import java.util.List;

import com.cognizant.attendanceMarking.auth.model.Admin;

public interface AdminService {
    void save(Admin Admin);
    List<Admin> getAll();
    void updateStatus(String adminId);
    
    void deleteAdminById(int id);
    Admin findByEmail(String email);
    Admin updateAdmin(Admin passwordForm);
    Admin findAdmin(Admin resetPassword);
    Admin forgotUsername(Admin forgotUsername);
    void rejectAdmin(int adminId);
}
