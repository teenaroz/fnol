package com.studentmanagementapp.bean;

import org.springframework.data.annotation.Id;

public class Student {
	
	@Id
	Integer id;
	String name;	
	int age;
	String subject;
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}
	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}
	/**
	 * @return the course
	 */
	public String getSubject() {
		return subject;
	}
	/**
	 * @param course the course to set
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "{\"name\":" + name + ", \"id\":" + id + ", \"age\":" + age + ", \"course\":=" + subject + "}";
	}
	
	

}
