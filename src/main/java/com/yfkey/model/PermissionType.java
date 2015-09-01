package com.yfkey.model;

public enum PermissionType {
	U("URL"), 
	B("BUTTON"),
	S("SUPPLIER"),
	P("PLANT");

	public String type() {
		return type;
	}

	private final String type;

	private PermissionType(String type) {
		this.type = type;
	}
}