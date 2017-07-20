package com.java.student.model;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.transaction.annotation.Transactional;


@Transactional
public interface StudentRepository extends MongoRepository<Student, String> {

	public List<Student> findByName(String name);

	public List<Student> findBySubject(String subject);

	public Student findById(Integer id);

	public void deleteById(Integer id);

	public void deleteByName(String name);

}