package com.yfkey.model;

import java.sql.Timestamp;

public interface Traceable {
	
	Timestamp getCreateDate();

	String getCreateUser();

	void setCreateDate(Timestamp createDate);

	void setCreateUser(String createUser);
}
