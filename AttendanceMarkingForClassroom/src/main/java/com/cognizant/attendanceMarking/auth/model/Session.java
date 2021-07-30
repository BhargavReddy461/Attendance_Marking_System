package com.cognizant.attendanceMarking.auth.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="sessions")
public class Session {

	@Id
	@Column(name="id")
	@GeneratedValue
	private int sessionId;
	@Column(name="session_desc")
	@NotEmpty(message = "The highlighted fields must not be empty")
	private String sessionDesc;
	@Column(name="skill_set")
	@NotEmpty(message = "The highlighted fields must not be empty")
	private String skillSet;
	@Column(name="time")
	@NotEmpty(message = "The highlighted fields must not be empty")
	private String sessionTime;
	@Column(name="date")
	private Date sessionDate;
	@Column(name="available_slots")
	private int availableSlots;
	
	@Column(name="is_deleted")
	private String isDeleted="false";
	
	private String feedbackform;
	
	public String getFeedbackform() {
		return feedbackform;
	}
	public void setFeedbackform(String feedbackform) {
		this.feedbackform = feedbackform;
	}
	public String getIsDeleted() {
		return isDeleted;
	}
	public void setIsDeleted(String isDeleted) {
		this.isDeleted = isDeleted;
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
	public String getSkillSet() {
		return skillSet;
	}
	public void setSkillSet(String skillSet) {
		this.skillSet = skillSet;
	}
	public String getSessionTime() {
		return sessionTime;
	}
	public void setSessionTime(String sessionTime) {
		this.sessionTime = sessionTime;
	}
	public Date getSessionDate() {
		return sessionDate;
	}
	public void setSessionDate(Date sessionDate) {
		this.sessionDate = sessionDate;
	}
	public int getAvailableSlots() {
		return availableSlots;
	}
	public void setAvailableSlots(int availableSlots) {
		this.availableSlots = availableSlots;
	}
	@Override
	public String toString() {
		return "Session [sessionId=" + sessionId + ", sessionDesc=" + sessionDesc + ", skillSet=" + skillSet
				+ ", sessionTime=" + sessionTime + ", sessionDate=" + sessionDate + ", availableSlots=" + availableSlots
				+ ", isDeleted=" + isDeleted + ", feedbackform=" + feedbackform + "]";
	}
	
	
	
}
