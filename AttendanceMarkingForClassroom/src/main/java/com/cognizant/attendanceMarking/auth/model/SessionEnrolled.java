package com.cognizant.attendanceMarking.auth.model;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="sessions_enrolled")
public class SessionEnrolled {
	@Id
	@Column(name="id")
	@GeneratedValue
private int id;
	@Column(name="user_id")
private int userId;
@Column(name="sessionId")
private int sessionId;
@Column(name="approval_status")
private String approvalStatus;
@Column(name="feedback")
private String feedback;
@Column(name="attendance")
private String attendance;
private String sessionDesc;
private String remainder;
public String getRemainder() {
	return remainder;
}

public void setRemainder(String remainder) {
	this.remainder = remainder;
}

public String getSessionDesc() {
	return sessionDesc;
}
public void setSessionDesc(String sessionDesc) {
	this.sessionDesc = sessionDesc;
}
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
public String getApprovalStatus() {
	return approvalStatus;
}
public void setApprovalStatus(String approvalStatus) {
	this.approvalStatus = approvalStatus;
}
public String getFeedback() {
	return feedback;
}
public void setFeedback(String feedback) {
	this.feedback = feedback;
}
public String getAttendance() {
	return attendance;
}
public void setAttendance(String attendance) {
	this.attendance = attendance;
}
@Override
public String toString() {
	return "SessionEnrolled [id=" + id + ", userId=" + userId + ", sessionId=" + sessionId + ", approvalStatus="
			+ approvalStatus + ", feedback=" + feedback + ", attendance=" + attendance + "]";
}

}
