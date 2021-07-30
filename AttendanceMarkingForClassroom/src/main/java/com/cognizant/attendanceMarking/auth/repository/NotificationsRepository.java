package com.cognizant.attendanceMarking.auth.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cognizant.attendanceMarking.auth.model.Notifications;

@Repository
public interface NotificationsRepository extends JpaRepository<Notifications, Integer> {
	@Query(value = "SELECT * FROM notifications", nativeQuery = true)
	public List<Notifications> findAllActiveUsers();

	@Query(value="select * from notifications where user_id=:userId order by id desc",nativeQuery=true)
	public List<Notifications> getAllNotifsByUserId(@Param("userId") int userId);
	
	@Query(value="select * from notifications where id=:Id",nativeQuery=true)
	public Notifications getNotifsById(@Param("Id") int Id);
	
	@Query(value="select * from notifications where session_id=:Id",nativeQuery=true)
	public Notifications getNotifsBySessionId(@Param("Id") int Id);
//	@Query(value="UPDATE admins SET status = 'inactive' where id = ?1",nativeQuery=true)
//	@Modifying
//	@Transactional
//	public int makeInactiveUsers(int id);
}
