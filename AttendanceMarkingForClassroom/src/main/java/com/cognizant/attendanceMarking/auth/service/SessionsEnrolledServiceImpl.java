package com.cognizant.attendanceMarking.auth.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.attendanceMarking.auth.model.Notifications;
import com.cognizant.attendanceMarking.auth.model.SessionEnrolled;
import com.cognizant.attendanceMarking.auth.repository.SessionsEnrolledRepository;

@Service
public class SessionsEnrolledServiceImpl implements SessionsEnrolledService {
	
	List<SessionEnrolled> userEnrolledSessions;

	@Autowired
	private SessionsEnrolledRepository repo;

	@Autowired
	private NotificationsService notificationService;

	@Override
	public Notifications create(SessionEnrolled user) {
		// TODO Auto-generated method stub
		repo.save(user);
		return null;
	}

	@Override
	public List<SessionEnrolled> getAll() {
		// TODO Auto-generated method stub

		return repo.findAllActiveUsers();
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);

	}

	@Override
	public List<SessionEnrolled> getByUserId(int id) {
		
		
		return repo.getByUserId(id);
	}
	
	@Override
	public List<SessionEnrolled> getByUser(int id) {
		
		
		return repo.getByUser(id);
	}
	

	@Override
	public List<SessionEnrolled> getBySessionId(int id) {
		// TODO Auto-generated method stub
		return repo.getBySessionId(id);
	}

	@Override
	public void updateStatus(String id) {
		// TODO Auto-generated method stub
		Optional<SessionEnrolled> sessions = repo.findById(Integer.parseInt(id));
		SessionEnrolled session = sessions.get();
		if (session.getApprovalStatus().equals("pending")) {
			session.setApprovalStatus("active");
			//notificationService.
		} else {
			session.setApprovalStatus("pending");
		}
		repo.save(session);
	}
	
	@Override
	public List<SessionEnrolled> getAllAttendedSessions() {
		
		
		return repo.getAllAttendedSessions();
	}
	
	@Override
	public SessionEnrolled getById(int id) {
		Optional<SessionEnrolled> session =repo.findById(id);
		return session.get();
	}
	
	@Override
	public void updateAttendance(SessionEnrolled session) {
		repo.save(session);
	}
	

}
