package com.cognizant.attendanceMarking.auth.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.attendanceMarking.auth.model.Notifications;
import com.cognizant.attendanceMarking.auth.repository.NotificationsRepository;

@Service
public class NotificationsServiceImpl implements NotificationsService {

	@Autowired
	private NotificationsRepository repo;
	@Override
	public Notifications create(Notifications user) {
		// TODO Auto-generated method stub
		Notifications notifications = repo.save(user);
		return null;
	}

	@Override
	public List<Notifications> getAll() {
		// TODO Auto-generated method stub
		return repo.findAllActiveUsers();
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		
		repo.deleteById(id);

	}

	@Override
	public void addNotification(Notifications notifications) {
		// TODO Auto-generated method stub

	}

	@Override
	public Notifications getById(int id) {
		// TODO Auto-generated method stub
		Notifications notifs=repo.getNotifsById(id);
		return notifs;
	}
	@Override
	public Notifications getBySessionId(int id) {
		// TODO Auto-generated method stub
		Notifications notifs=repo.getNotifsBySessionId(id);
		return notifs;
	}
	@Override
	public List<Notifications> getByUserId(int id) {
		// TODO Auto-generated method stub
		List<Notifications> notifs=repo.getAllNotifsByUserId(id);
		return notifs;
	}

}
