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
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;


@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	StudentRepository repository;
	
	@RequestMapping(value = "/add", method = RequestMethod.PUT)
	@HystrixCommand(fallbackMethod = "displayStudents")	
	public String add(@RequestBody Student student) {

		repository.save(student);
		return "Student added successfully";

	}

	@RequestMapping(value = "/findAll", method = RequestMethod.GET)
	@HystrixCommand(fallbackMethod = "displayStudents")
	public List<Student> getStudent() {

		return repository.findAll();

	}

	@RequestMapping(value = "/getStudenByName", method = RequestMethod.GET)
	@HystrixCommand(fallbackMethod = "displayStudents")
	public List<Student> getStudentByName(@RequestParam("name") String studentName) {

		return repository.findByName(studentName);
	}
	
	@RequestMapping(value = "/getStudenById", method = RequestMethod.GET)
	@HystrixCommand(fallbackMethod = "displayStudents")
	public List<Student> getStudentById(@RequestParam("id") String studentId) {

		return repository.findByName(studentId);
	}

	@RequestMapping(value = "/getStudentBySubject", method = RequestMethod.GET)
	@HystrixCommand(fallbackMethod = "displayStudents")
	public List<Student> getStudentBySubject(@RequestParam("subject") String subject) {
		return repository.findBySubject(subject);

	}
	
	@RequestMapping(value = "/updateStudent", method = RequestMethod.POST)
	@HystrixCommand(fallbackMethod = "displayStudents")
	public String updateStudent(@RequestBody Student student) {

		if (repository.findById(student.getId()) != null) {
			repository.save(student);
			return "Student updated successfully";
		}

		return "Student record not found.";
	}

	@RequestMapping(value = "/deleteStudentById", method = RequestMethod.DELETE)
	public String deleteStudentById(@RequestParam("id") int studentId) {
		if (repository.findById(studentId) != null) {
			repository.deleteById(studentId);
			return "Student info deleted successfully for id:" + studentId;
		}

		return "Student record not found.";

	}



	public List<Student> displayStudents() {
		return new ArrayList<Student>();
	}

}