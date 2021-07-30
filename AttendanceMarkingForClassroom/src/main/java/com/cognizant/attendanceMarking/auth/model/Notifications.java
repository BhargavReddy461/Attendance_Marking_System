package com.cognizant.attendanceMarking.auth.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "notifications")
public class Notifications {
	@Id
	@Column(name = "id")
	@GeneratedValue
	private int id;
	@Column(name = "user_id")
	private int userId;
	@Column(name = "session_id")
	private int sessionId;
	@Column(name = "session_desc")
	private String sessionDesc;
	private String status;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSessionId() {
		return sessionId;
	}

	public void setSessionId(int sessionId) {
		this.sessionId = sessionId;
	}

	public String getSessionDesc() {
		return sessionDesc;
	}

	public void setSessionDesc(String sessionDesc) {
		this.sessionDesc = sessionDesc;
	}

	@Override
	public String toString() {
		return "Notifications [id=" + id + ", sessionId=" + sessionId + ", sessionDesc=" + sessionDesc + "]";
	}

}
