package com.cognizant.attendanceMarking.auth.model;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User extends Client{
private String security1;
    
    private String security2;

	public String getSecurity1() {
		return security1;
	}

	public void setSecurity1(String security1) {
		this.security1 = security1;
	}

	public String getSecurity2() {
		return security2;
	}

	public void setSecurity2(String security2) {
		this.security2 = security2;
	}
    
}
