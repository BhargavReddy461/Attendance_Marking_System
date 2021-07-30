package com.cognizant.attendanceMarking.auth.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cognizant.attendanceMarking.auth.model.SkillSession;




public interface SkillSessionService {
	SkillSession create(SkillSession skillSession);
	List<SkillSession> getAll();
	void deleteById(int id);
	void addSkillSession(SkillSession skillSession);
	void updateSkillSession(SkillSession skillSession);
	//RAdmin LoginUser(String username,String password);
}
