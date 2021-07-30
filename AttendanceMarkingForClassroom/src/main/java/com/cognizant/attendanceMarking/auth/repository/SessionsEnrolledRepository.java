package com.cognizant.attendanceMarking.auth.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cognizant.attendanceMarking.auth.model.SessionEnrolled;

@Repository
public interface SessionsEnrolledRepository extends JpaRepository<SessionEnrolled, Integer> {
	@Query(value = "SELECT * FROM sessions_enrolled", nativeQuery = true)
	public List<SessionEnrolled> findAllActiveUsers();
	
	@Query(value="select * from sessions_enrolled where user_id=:id", nativeQuery = true)
	public List<SessionEnrolled> getByUserId(@Param("id") int id);
	
	@Query(value="select * from sessions_enrolled where user_id=:id and attendance='Yes'", nativeQuery = true)
	public List<SessionEnrolled> getByUser(@Param("id") int id);
	
	@Query(value="select * from sessions_enrolled where session_id=:id and attendance='Yes'", nativeQuery = true)
	public List<SessionEnrolled> getBySessionId(@Param("id") int id);
	
	
	@Query(value="select * from sessions_enrolled where attendance='Yes'", nativeQuery = true)
	public List<SessionEnrolled> getAllAttendedSessions();
	

	
//	@Query(value="select * from notifications where user_id=:userId order by id desc",nativeQuery=true)
//	public List<Notifications> getAllNotifsByUserId(@Param("userId") int userId);
//	
//	@Query(value="select * from notifications where id=:Id",nativeQuery=true)
//	public Notifications getNotifsById(@Param("Id") int Id);
//	@Query(value="UPDATE admins SET status = 'inactive' where id = ?1",nativeQuery=true)
//	@Modifying
//	@Transactional
//	public int makeInactiveUsers(int id);
}
