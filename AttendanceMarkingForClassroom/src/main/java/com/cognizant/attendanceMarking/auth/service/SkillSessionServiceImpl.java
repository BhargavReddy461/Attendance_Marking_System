package com.cognizant.attendanceMarking.auth.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.attendanceMarking.auth.model.SkillSession;
import com.cognizant.attendanceMarking.auth.repository.SkillSessionRepository;



@Service
public class SkillSessionServiceImpl implements SkillSessionService {

	@Autowired
	private SkillSessionRepository repo;

	@Override
	public SkillSession create(SkillSession skillSession) {
		// TODO Auto-generated method stub
		System.out.println("In skill");
		SkillSession tra = repo.save(skillSession);
		return null;
	}

	@Override
	public List<SkillSession> getAll() {
		// TODO Auto-generated method stub
		return repo.findAllActiveUsers();
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
	}

	@Override
	public void addSkillSession(SkillSession skillSession) {
		// TODO Auto-generated method stub

	}
	@Override
	public void updateSkillSession(SkillSession skillSession) {
	    //Optional<Session> findById = repo.findById(session.getSessionId());
	    // crush the variables of the object found
	   // Session session1=findById.get();
//	    session1.setSessionDesc(session.getSessionDesc());
//	    session1.setSkillSet(session.getSkillSet());
//	    session1.setSessionTime(session.getSessionTime());
//	    session1.setSessionDate(session.getSessionDate());
//	    session1.setAvailableSlots(session.getAvailableSlots());
	    //repo.save(session1);
	}

}
