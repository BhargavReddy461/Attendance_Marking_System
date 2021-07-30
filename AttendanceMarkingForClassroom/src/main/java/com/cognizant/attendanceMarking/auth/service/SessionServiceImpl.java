package com.cognizant.attendanceMarking.auth.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.attendanceMarking.auth.model.Session;
import com.cognizant.attendanceMarking.auth.repository.SessionRepository;



@Service
public class SessionServiceImpl implements SessionService {

	private static final String String = null;
	@Autowired
	private SessionRepository repo;

	@Override
	public Session create(Session session) {
		// TODO Auto-generated method stub
		System.out.println("Session saved");
		Session tra = repo.save(session);
		return null;
	}

	@Override
	public List<Session> getAll() {
		// TODO Auto-generated method stub
		return repo.findAllActiveUsers();
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
//		System.out.println(String.valueOf(id));
//		repo.updateSession(String.valueOf(id));
	}

	@Override
	public void addSession(Session session) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateSession(int id) {
		Optional<Session> findById = repo.findById(id);

		// crush the variables of the object found

		Session session1 = findById.get();
		session1.setIsDeleted("true");
		repo.save(session1);

	}

	@Override
	public void updateUser(Session session) {
		Optional<Session> findById = repo.findById(session.getSessionId());
		// crush the variables of the object found
		Session session1 = findById.get();
		session1.setSessionDesc(session.getSessionDesc());
		session1.setSkillSet(session.getSkillSet());
		session1.setSessionTime(session.getSessionTime());
		session1.setSessionDate(session.getSessionDate());
		session1.setAvailableSlots(session.getAvailableSlots());
		repo.save(session1);
	}

	@Override
	public Session findSessionDetails(int id) {
		// TODO Auto-generated method stub

		Optional<Session> session = repo.findById(id);
		if (session.isEmpty()) {
			return null;
		}
		return session.get();
	}

	@Override
	public List<Session> getAllBySkillId(String id) {
		// TODO Auto-generated method stub
		return repo.findSessionsBasedOnId(id);
	}
	
	@Override
	public List<Session> findAllSessionsTime() {
		// TODO Auto-generated method stub
		return repo.findAllSessionsTime();	}

	@Override
	public int sessionTime(int id) {
		// TODO Auto-generated method stub
		return repo.findSessionTime(id);
	}
	
	@Override
	public List<Session> getAllBySkill(String skill){
		return repo.findSessionsBasedOnSkill("%"+skill+"%");
	}

}