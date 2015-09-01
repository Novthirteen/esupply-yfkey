package com.yfkey.model;

public enum Gender {
	F("FEMALE"), 
	M("MALE");
	
	public String gender() {
		return gender;
	}

	private final String gender;

	private Gender(String gender) {
		this.gender = gender;
	}
}
