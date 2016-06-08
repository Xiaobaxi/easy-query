package com.engineer.common.easyquery.validation;

import java.io.Serializable;
import java.util.Date;
import javax.validation.constraints.Future;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

public class User implements Serializable {
	
	/**
	 * TODO(用一句话描述这个变量表示什么)
	 */
	private static final long serialVersionUID = -397710323307915274L;
	private Long id;
	@NotNull
	@Size(min = 1, max = 20)
	private String name;
	@NotNull(groups = UserService.Insert.class)
	private String password;
	private String sex;
	@Min(18)
	@Max(100)
	private int age;
	@Past
	private Date birthDate;
	@Future
	private Date marryDate;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getSex() {
		return sex;
	}
	
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public Date getBirthDate() {
		return birthDate;
	}
	
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	
	public Date getMarryDate() {
		return marryDate;
	}
	
	public void setMarryDate(Date marryDate) {
		this.marryDate = marryDate;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", password=" + password + ", sex=" + sex + ", birthDate=" + birthDate + ", marryDate=" + marryDate + "]";
	}
}
