package com.student.model;

import org.springframework.data.annotation.Id;

public class Student {

	@Id
	private String id;
	private String name;
	private String subject;

	public Student() {
	}

	public Student(String id, String name, String subject) {
		super();
		this.id = id;
		this.name = name;
		this.subject = subject;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

}
