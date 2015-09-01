package com.yfkey.model;

import java.sql.Timestamp;

public interface Auditable extends Traceable {
	Timestamp getUpdateDate();

	String getUpdateUser();

	void setUpdateDate(Timestamp updateDate);

	void setUpdateUser(String updateUser);
}
