package com.cognizant.attendanceMarking.auth.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cognizant.attendanceMarking.auth.model.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer> {
    Admin findByEmail(String email);
    
    @Query(value = "SELECT * FROM admin", nativeQuery = true)
	public List<Admin> findAllActiveUsers();
}
