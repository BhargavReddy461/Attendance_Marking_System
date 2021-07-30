package com.cognizant.attendanceMarking.auth.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="skills")
public class Skill {
	@Id
	@GeneratedValue
	@Column(name="id")
private int skillId;
	@Column(name="skill_type")
	@NotEmpty(message = "The highlighted fields must not be empty")
private String skillType;
	@Column(name="skill_desc")
	@NotEmpty(message = "The highlighted fields must not be empty")
private String skillDesc;
public int getSkillId() {
	return skillId;
}
public void setSkillId(int skillId) {
	this.skillId = skillId;
}
public String getSkillType() {
	return skillType;
}
public void setSkillType(String skillType) {
	this.skillType = skillType;
}
public String getSkillDesc() {
	return skillDesc;
}
public void setSkillDesc(String skillDesc) {
	this.skillDesc = skillDesc;
}
@Override
public String toString() {
	return "Skill [skillId=" + skillId + ", skillType=" + skillType + ", skillDesc=" + skillDesc + "]";
}

}
