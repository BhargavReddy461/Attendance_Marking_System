package com.cognizant.attendanceMarking.auth.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cognizant.attendanceMarking.auth.model.SessionUser;

@Repository
public interface SessionUserRepository extends JpaRepository<SessionUser, Integer> {
	@Query(value = "SELECT * FROM session_user_mapping", nativeQuery = true)
	public List<SessionUser> findAllActiveUsers();

	@Query(value="select * from session_user_mapping where user_id=:id",nativeQuery=true)
	public List<SessionUser> findAllByUserId(@Param("id") int userId);
}
