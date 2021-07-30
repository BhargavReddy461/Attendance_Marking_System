package com.cognizant.attendanceMarking.auth.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cognizant.attendanceMarking.auth.model.Trainer;


@Repository
public interface TrainerRepository extends JpaRepository<Trainer, Integer> {
	@Query(value = "SELECT * FROM trainers where is_deleted='false'", nativeQuery = true)
	public List<Trainer> findAllActiveUsers();

//	@Query(value="UPDATE admins SET status = 'inactive' where id = ?1",nativeQuery=true)
//	@Modifying
//	@Transactional
//	public int makeInactiveUsers(int id);
}
