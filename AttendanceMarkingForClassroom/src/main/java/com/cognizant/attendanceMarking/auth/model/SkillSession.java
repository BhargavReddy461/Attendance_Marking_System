package com.cognizant.attendanceMarking.auth.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="skill_session_mapping")
public class SkillSession {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int skillId;
	private int sessionId;
	public int getSkillId() {
		return skillId;
	}
	public void setSkillId(int skillId) {
		this.skillId = skillId;
	}
	public int getSessionId() {
		return sessionId;
	}
	public void setSessionId(int sessionId) {
		this.sessionId = sessionId;
	}
	@Override
	public String toString() {
		return "SkillSession [skillId=" + skillId + ", sessionId=" + sessionId + "]";
	}
	
}
