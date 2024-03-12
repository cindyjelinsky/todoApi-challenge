package com.todochallenge.todochallenge.enums;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonValue;

@JsonFormat(shape= JsonFormat.Shape.OBJECT)
public enum Priority {
	
	HIGH("High"),
	MEDIUM("Medium"),
	LOW("Low");

	

	private String  priority;
	
	
	private Priority(String priority) {
		this.priority = priority;
	}

	@JsonValue
	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}
	
	
}
	


	
	
		
	

