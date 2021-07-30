package com.cognizant.attendanceMarking.auth.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cognizant.attendanceMarking.auth.model.Session;
import com.cognizant.attendanceMarking.auth.model.Skill;


@Service
public interface SkillService {
	Session create(Skill skill);
	List<Skill> getAll();
	void deleteById(int id);
	void addSkill(Skill skill);
	//RAdmin LoginUser(String username,String password);
}
