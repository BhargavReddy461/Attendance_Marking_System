package com.cognizant.attendanceMarking.auth.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "session_user_mapping")
public class SessionUser {
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;
	@Column(name="user_id")
	private int userId;
	@Column(name="session_id")
	private int sessionId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getSessionId() {
		return sessionId;
	}

	public void setSessionId(int sessionId) {
		this.sessionId = sessionId;
	}

	@Override
	public String toString() {
		return "SessionUser [id=" + id + ", userId=" + userId + ", sessionId=" + sessionId + "]";
	}

}
