package com.cognizant.attendanceMarking.auth.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "trainers")
public class Trainer {
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int trainerId;
	
	@Column(name = "trainer_name")
	@NotEmpty(message = "The highlighted fields must not be empty")
	private String trainerName;
	
	@Column(name = "phone")
	@Pattern(regexp = "^[987]{1}[0-9]{9}$",message="contact number should contain 10 digits")
	private String contactNo;
	
	@Column(name = "email")
	@NotEmpty(message = "The highlighted fields must not be empty")
	private String traineremail;
	

	@Column(name = "skill_set")
	@NotEmpty(message = "The highlighted fields must not be empty")
	private String skillset;
	
	@Column(name = "is_deleted")
	private String isDeleted = "false";

public String getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(String isDeleted) {
		this.isDeleted = isDeleted;
	}


	public int getTrainerId() {
		return trainerId;
	}

	public void setTrainerId(int trainerId) {
		this.trainerId = trainerId;
	}

	public String getTrainerName() {
		return trainerName;
	}

	public void setTrainerName(String trainerName) {
		this.trainerName = trainerName;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	

public String getTraineremail() {
		return traineremail;
	}

	public void setTraineremail(String traineremail) {
		this.traineremail = traineremail;
	}

	//public Skill getSkillset() {
//	return skillset;
//}
//public void setSkillset(Skill skillset) {
//	this.skillset = skillset;
//}
	public String getSkillset() {
		return skillset;
	}

	public void setSkillset(String skillset) {
		this.skillset = skillset;
	}

	@Override
	public String toString() {
		return "Trainer [trainerId=" + trainerId + ", trainerName=" + trainerName + ", contactNo=" + contactNo
				+ ", traineremail=" + traineremail + ", skillset=" + skillset + "]";
	}

}
