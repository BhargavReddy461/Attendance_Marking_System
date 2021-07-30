package com.cognizant.attendanceMarking.auth.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cognizant.attendanceMarking.auth.model.Session;


@Repository
public interface SessionRepository extends JpaRepository<Session, Integer> {
	@Query(value = "SELECT * FROM sessions  WHERE is_deleted='false'", nativeQuery = true)
	public List<Session> findAllActiveUsers();
	
	@Query(value="SELECT * FROM sessions WHERE id IN (SELECT session_id FROM skill_session_mapping WHERE skill_id=:id)",nativeQuery=true)
	public List<Session> findSessionsBasedOnId(@Param("id") String id);

	@Query(value = "select * from sessions where DATEDIFF(NOW(), date)=3", nativeQuery = true)
	public List<Session> findAllSessionsTime();

	@Query(value = "select DATEDIFF(NOW(),date) from sessions where id=:id", nativeQuery = true)
	public int findSessionTime(@Param("id") int id);
	
	@Query(value="SELECT * FROM sessions WHERE skill_set like :skill",nativeQuery=true)
	public List<Session> findSessionsBasedOnSkill(@Param("skill") String skill);
}
