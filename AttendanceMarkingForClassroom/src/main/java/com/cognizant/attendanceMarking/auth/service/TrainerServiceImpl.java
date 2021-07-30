package com.cognizant.attendanceMarking.auth.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.attendanceMarking.auth.model.Trainer;
import com.cognizant.attendanceMarking.auth.repository.TrainerRepository;



@Service
public class TrainerServiceImpl implements TrainerService {

	@Autowired
	private TrainerRepository repo;

	@Override
	public Trainer create(Trainer trainer) {
		// TODO Auto-generated method stub
		Trainer tra=repo.save(trainer);
		return null;
	}

	@Override
	public List<Trainer> getAll() {
		// TODO Auto-generated method stub
		return repo.findAllActiveUsers();
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
	}

	@Override
	public void addTrainer(Trainer trainer) {
		// TODO Auto-generated method stub

	}
	
	@Override
	public void updateTrainer(Trainer trainer) {
		Optional<Trainer> findById=repo.findById(trainer.getTrainerId());
		Trainer trainer1=findById.get();
		trainer1.setTrainerName(trainer.getTrainerName());
		trainer1.setContactNo(trainer.getContactNo());
		trainer1.setTraineremail(trainer.getTraineremail());
		trainer1.setSkillset(trainer.getSkillset());
		repo.save(trainer1);
		
	}

	@Override
	public void updateTrainer(int id) {
		// TODO Auto-generated method stub
		Optional<Trainer> findById = repo.findById(id);
		Trainer trainer1=findById.get();
		trainer1.setIsDeleted("true");
		repo.save(trainer1);
	}

}