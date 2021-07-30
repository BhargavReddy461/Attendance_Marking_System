package com.cognizant.attendanceMarking.auth.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.cognizant.attendanceMarking.auth.model.Session;



@Service
public interface SessionService {
	Session create(Session session);
	List<Session> getAll();
	List<Session> getAllBySkillId(String id);
	void deleteById(int id);
	void addSession(Session session);
	void updateSession(int id);
	void updateUser(Session session);
	Session findSessionDetails(int id);
	List<Session> findAllSessionsTime();
	int sessionTime(int id);
	List<Session> getAllBySkill(String skill);
	
	
}
