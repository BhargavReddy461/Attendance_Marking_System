package com.cognizant.attendanceMarking.auth.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.attendanceMarking.auth.model.SessionUser;
import com.cognizant.attendanceMarking.auth.repository.SessionUserRepository;

@Service
public class SessionUserServiceImpl implements SessionUserService {

	@Autowired
	private SessionUserRepository repo;

	@Override
	public SessionUser create(SessionUser sessionUser) {
		// TODO Auto-generated method stub
		SessionUser tra = repo.save(sessionUser);
		return tra;
	}

	@Override
	public List<SessionUser> getAll() {
		// TODO Auto-generated method stub
		
		return repo.findAllActiveUsers();
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
	}

	@Override
	public void addSessionUser(SessionUser sessionUser) {
		// TODO Auto-generated method stub
	

	}

	@Override
	public void updateSessionUser(SessionUser sessionUser) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<SessionUser> getAllSessionById(int userId) {
		// TODO Auto-generated method stub
	//should add when we maintain sessions and get UserId
		return repo.findAllByUserId(userId);
	}

	@Override
	public SessionUser searchIfEnrolled(int userId,int sessionId) {
		// TODO Auto-generated method stub
		List<SessionUser> sessions=getAllSessionById(userId);
		for(SessionUser session:sessions) {
			if(session.getSessionId()==sessionId) {
				return session;
			}
		}
		return null;
	}

}
