package com.studentmanagementapp.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.studentmanagementapp.bean.Student;
import com.studentmanagementapp.datastore.StudentRepository;

@RestController
@RequestMapping(value = "/students")
@Service
public class StudentServicesWithPersistance {

	@Autowired
	StudentRepository repository;

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	@HystrixCommand(fallbackMethod = "defaultStudents")
	public List<Student> getStudent() {

		return repository.findAll();

	}

	@RequestMapping(value = "/studentInfoById", method = RequestMethod.GET)
	@HystrixCommand(fallbackMethod = "defaultStudents")
	public String getStudentById(@RequestParam("id") int studentId) {
		Student student = repository.findById(studentId);

		if (null != student) {
			return student.toString();
		}
		return null;
	}

	@RequestMapping(value = "/studentInfoByName", method = RequestMethod.GET)
	@HystrixCommand(fallbackMethod = "defaultStudents")
	public List<Student> getStudentByName(@RequestParam("name") String studentName) {

		return repository.findByName(studentName);
	}

	@RequestMapping(value = "/studentInfoBySubject", method = RequestMethod.GET)
	@HystrixCommand(fallbackMethod = "defaultStudents")
	public List<Student> getStudentBySubject(@RequestParam("subject") String subject) {
		return repository.findBySubject(subject);

	}

	@RequestMapping(value = "/addStudent", method = RequestMethod.PUT)
	@HystrixCommand(fallbackMethod = "defaultStudents")
	public String putStudent(@RequestBody Student student) {

		repository.save(student);
		return "Student info added successfully";

	}

	@RequestMapping(value = "/RemoveInfoById", method = RequestMethod.DELETE)
	@HystrixCommand(fallbackMethod = "defaultStudents")
	public String deleteStudentById(@RequestParam("id") int studentId) {
		if (repository.findById(studentId) != null) {
			repository.deleteById(studentId);
			return "Student info deleted successfully for id:" + studentId;
		}

		return "Student info record not found for the given Id";

	}

	@RequestMapping(value = "/RemoveInfoByName", method = RequestMethod.DELETE)
	@HystrixCommand(fallbackMethod = "defaultDeleteStudents")
	public String deleteStudentByName(@RequestParam("name") String studentName) {
		if (repository.findByName(studentName) != null) {
			repository.deleteByName(studentName);
			return "Student info deleted successfully for Student name:" + studentName;
		}

		return "Student info record not found for the given Id";

	}

	@RequestMapping(value = "/updateInfo", method = RequestMethod.POST)
	@HystrixCommand(fallbackMethod = "defaultStudents")
	public String updateStudent(@RequestBody Student student) {

		if (repository.findById(student.getId()) != null) {
			repository.save(student);
			return "Student info record updated successfully";
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
