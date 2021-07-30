package com.cognizant.attendanceMarking.auth.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.attendanceMarking.auth.model.Session;
import com.cognizant.attendanceMarking.auth.model.Skill;
import com.cognizant.attendanceMarking.auth.repository.SkillRepository;


@Service
public class SkillServiceImpl implements SkillService {

	@Autowired
	private SkillRepository repo;

	@Override
	public Session create(Skill skill) {
		// TODO Auto-generated method stub
		System.out.println("Session saved");
		Skill tra = repo.save(skill);
		return null;
	}

	@Override
	public List<Skill> getAll() {
		// TODO Auto-generated method stub
		return repo.findAllActiveUsers();
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addSkill(Skill skill) {
		// TODO Auto-generated method stub

	}

}
