package com.cognizant.attendanceMarking.auth.model;

import javax.persistence.*;

@Entity
@Table(name = "admin")
public class Admin extends Client{
    

	
    
    private int age;
    
    private String gender;
    
    private Long contact;
    
    private String status;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
    public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Long getContact() {
		return contact;
	}

	public void setContact(Long contact) {
		this.contact = contact;
	}

	
    

    
    

    
}
