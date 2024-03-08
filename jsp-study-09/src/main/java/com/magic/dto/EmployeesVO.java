package com.magic.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/*
 * create table employees(
    id varchar2(10) not null primary key,
    pass varchar2(10) not null,
    name varchar2(24),
    lev char(1) default 'A',
    enter date default sysdate,
    gender char(1) default '1',
    phone varchar2(20)
    
);
 */
@Setter
@Getter
@ToString
public class EmployeesVO {
	private String id;
	private String pass;
	private String name;
	private String lev;
	private Date enter;
	private String gender;
	private String phone;
}
