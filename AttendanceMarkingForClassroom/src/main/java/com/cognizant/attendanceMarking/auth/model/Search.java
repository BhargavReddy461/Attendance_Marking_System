package com.cognizant.attendanceMarking.auth.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class Search {

	@NotEmpty(message = "Type an Id to search")
	private String id;
	@NotEmpty(message = "Choose an option to search")
	@NotNull(message = "choose an option")
	private String option;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOption() {
		return option;
	}

	public void setOption(String option) {
		this.option = option;
	}

	@Override
	public String toString() {
		return "Search [id=" + id + ", option=" + option + "]";
	}

}
