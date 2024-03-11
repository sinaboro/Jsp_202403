package com.magic.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/*
 * ID     NOT NULL VARCHAR2(10) 
	PASS   NOT NULL VARCHAR2(10) 
	NAME            VARCHAR2(24) 
	LEV             CHAR(1)      
	ENTER           DATE         
	GENDER          CHAR(1)      
	PHONE           VARCHAR2(30) 
 */
@Getter
@Setter
@ToString
public class EmployeesVO {
	String id;
	String pass;
	String name;
	String lev;
	Date enter;
	int gender;
	String phone;
}
