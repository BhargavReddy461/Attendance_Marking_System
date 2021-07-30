package com.cognizant.attendanceMarking.auth.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cognizant.attendanceMarking.auth.model.SkillSession;



@Repository
public interface SkillSessionRepository extends JpaRepository<SkillSession, Integer> {
	@Query(value = "SELECT * FROM skill_session_mapping", nativeQuery = true)
	public List<SkillSession> findAllActiveUsers();

}
