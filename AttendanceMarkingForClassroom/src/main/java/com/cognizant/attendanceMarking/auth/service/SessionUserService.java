package com.cognizant.attendanceMarking.auth.service;

import java.util.List;

import com.cognizant.attendanceMarking.auth.model.SessionUser;


public interface SessionUserService {
	SessionUser create(SessionUser sessionUser);
	List<SessionUser> getAll();
	void deleteById(int id);
	void addSessionUser(SessionUser sessionUser);
	void updateSessionUser(SessionUser sessionUser);
	List<SessionUser> getAllSessionById(int userId);
	SessionUser searchIfEnrolled(int userId,int sessionId);
	//RAdmin LoginUser(String username,String password);
}
