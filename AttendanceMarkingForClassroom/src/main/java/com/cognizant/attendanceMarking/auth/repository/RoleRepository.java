package com.cognizant.attendanceMarking.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.attendanceMarking.auth.enums.Roles;
import com.cognizant.attendanceMarking.auth.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
	
	Role findByRole(Roles role);
}
