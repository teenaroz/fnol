package com.java.student.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.java.student.model.Student;
import com.java.student.model.StudentRepository;


@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	StudentRepository repository;
	
	@RequestMapping(value = "/add", method = RequestMethod.PUT)
	public String add(@RequestBody Student student) {

		repository.save(student);
		return "Student added successfully";

	}

	@RequestMapping(value = "/findAll", method = RequestMethod.GET)
	public List<Student> getStudent() {

		return repository.findAll();

	}

	@RequestMapping(value = "/getStudenByName", method = RequestMethod.GET)
	public List<Student> getStudentByName(@RequestParam("name") String studentName) {

		return repository.findByName(studentName);
	}
	
	@RequestMapping(value = "/getStudenById", method = RequestMethod.GET)
	public List<Student> getStudentById(@RequestParam("id") String studentId) {

		return repository.findByName(studentId);
	}

	@RequestMapping(value = "/getStudentBySubject", method = RequestMethod.GET)
	public List<Student> getStudentBySubject(@RequestParam("subject") String subject) {
		return repository.findBySubject(subject);

	}
	
	@RequestMapping(value = "/updateStudent", method = RequestMethod.POST)
	public String updateStudent(@RequestBody Student student) {

		if (repository.findById(student.getId()) != null) {
			repository.save(student);
			return "Student info record updated successfully";
		}

		return "Student info record not found for the given Id";
	}

	@RequestMapping(value = "/deleteStudentById", method = RequestMethod.DELETE)
	public String deleteStudentById(@RequestParam("id") int studentId) {
		if (repository.findById(studentId) != null) {
			repository.deleteById(studentId);
			return "Student info deleted successfully for id:" + studentId;
		}

		return "Student info record not found for the given Id";

	}



	public List<Student> defaultStudents() {
		return new ArrayList<Student>();
	}

	public String defaultStudents(int id) {
		return "";
	}

	public List<Student> defaultStudents(String name) {
		return new ArrayList<Student>();
	}

	public String defaultStudents(Student student) {
		return "";
	}

	public String defaultDeleteStudents(String string) {
		return "";
	}

}