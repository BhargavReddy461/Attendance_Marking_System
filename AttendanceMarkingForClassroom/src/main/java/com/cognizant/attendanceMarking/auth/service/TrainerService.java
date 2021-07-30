package com.cognizant.attendanceMarking.auth.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cognizant.attendanceMarking.auth.model.Trainer;


@Service
public interface TrainerService {
	Trainer create(Trainer trainer);
	List<Trainer> getAll();
	void deleteById(int id);
	void addTrainer(Trainer trainer);
	void updateTrainer(Trainer trainer);
	void updateTrainer(int id);
	//RAdmin LoginUser(String username,String password);
}
