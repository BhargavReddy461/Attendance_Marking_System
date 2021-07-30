package com.cognizant.attendanceMarking.auth.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cognizant.attendanceMarking.auth.model.Notifications;
import com.cognizant.attendanceMarking.auth.model.SessionEnrolled;

@Service
public interface SessionsEnrolledService {

	Notifications create(SessionEnrolled user);

	List<SessionEnrolled> getAll();

	void deleteById(int id);

//	void addNotification(Notifications notifications);
	List<SessionEnrolled> getByUserId(int id);
	List<SessionEnrolled> getByUser(int id);
	SessionEnrolled getById(int id);

	
	public void updateStatus(String userId);
	
	List<SessionEnrolled> getAllAttendedSessions();
	List<SessionEnrolled> getBySessionId(int id);
	void updateAttendance(SessionEnrolled session);
}
