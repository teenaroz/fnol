package com.student.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.student.model.Student;

public interface StudentRepository extends MongoRepository<Student, String> {

	List<Student> findByName(String studentName);

	List<Student> findBySubject(String studentSubject);

}
