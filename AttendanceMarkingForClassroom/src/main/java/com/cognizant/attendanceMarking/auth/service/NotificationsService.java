package com.cognizant.attendanceMarking.auth.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cognizant.attendanceMarking.auth.model.Notifications;
@Service
public interface NotificationsService {
	
	Notifications create(Notifications user);
	List<Notifications> getAll();
	void deleteById(int id);
	void addNotification(Notifications notifications);
	List<Notifications> getByUserId(int id);
	Notifications getById(int id);
	Notifications getBySessionId(int id);
}
