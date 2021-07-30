package com.cognizant.attendanceMarking.auth.model;

import javax.persistence.*;

import com.cognizant.attendanceMarking.auth.enums.Roles;

@Entity
public class Role {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Enumerated(EnumType.STRING)
	private Roles role;
	
	public Roles getRole() {
		return role;
	}

}
