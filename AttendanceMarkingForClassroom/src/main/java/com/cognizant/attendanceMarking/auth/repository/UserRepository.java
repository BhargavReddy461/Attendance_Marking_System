package com.cognizant.attendanceMarking.auth.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cognizant.attendanceMarking.auth.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    
    @Query(value="SELECT * FROM user",nativeQuery=true)
	public List<User> findAllActiveUsers();
    @Query(value="SELECT * FROM user WHERE email=:email",nativeQuery=true)
    public User findByEmail(@Param("email") String email);
}
