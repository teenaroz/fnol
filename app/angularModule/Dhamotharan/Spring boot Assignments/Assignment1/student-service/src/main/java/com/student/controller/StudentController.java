package com.student.controller;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.student.model.Student;
import com.student.repository.StudentRepository;


@RestController
@EnableCircuitBreaker
@RequestMapping("/student")
public class StudentController {

  @Autowired
  private StudentRepository studentRepository;
  
  @RequestMapping(method = RequestMethod.POST)
  public Map<String, Object> createStudent(@RequestBody Map<String, Object> bookMap){
	  Student book = new Student(bookMap.get("id").toString(), 
        bookMap.get("name").toString(),
        bookMap.get("subject").toString());
    
    Map<String, Object> response = new LinkedHashMap<String, Object>();
    response.put("message", "student created successfully");
    response.put("student", studentRepository.save(book));
    return response;
  }
  
  @RequestMapping(method = RequestMethod.GET, value="id/{studentId}")
  public Student getStudentDetailById(@PathVariable("studentId") String studentId){
    return studentRepository.findOne(studentId);
  }
  
  @RequestMapping(method = RequestMethod.GET, value="name/{studentName}")
  public List<Student> getStudentDetailByName(@PathVariable("studentName") String studentName){
    return studentRepository.findByName(studentName);
  }
  
  @RequestMapping(method = RequestMethod.GET, value="subject/{studentSubject}")
  public List<Student> getStudentDetailBySubject(@PathVariable("studentSubject") String studentSubject){
    return studentRepository.findBySubject(studentSubject);
  }
  
  
  @RequestMapping(method = RequestMethod.PUT, value="/{studentId}")
  public Map<String, Object> updateStudent(@PathVariable("studentId") String studentId, 
      @RequestBody Map<String, Object> bookMap){
    Student book = new Student(bookMap.get("name").toString(), 
        bookMap.get("name").toString(),
        bookMap.get("subject").toString());
    book.setId(studentId);
    
    Map<String, Object> response = new LinkedHashMap<String, Object>();
    response.put("message", "Student Updated successfully");
    response.put("student", studentRepository.save(book));
    return response;
  }
  
  
  @RequestMapping(method = RequestMethod.DELETE, value="/{studentId}")
  public Map<String, String> deleteStudent(@PathVariable("studentId") String studentId){
    studentRepository.delete(studentId);
    Map<String, String> response = new HashMap<String, String>();
    response.put("message", "Student deleted successfully");
    
    return response;
  }
  
  
  @HystrixCommand(fallbackMethod = "testMethod")
  @RequestMapping(method = RequestMethod.GET)
  public Map<String, Object> getAllStudents(){
    List<Student> students = studentRepository.findAll();
    Map<String, Object> response = new LinkedHashMap<String, Object>();
    response.put("totalStudents", students.size());
    response.put("books", students);
    return response;
  }
  
  public Map<String, Object> testMethod() {

	    List<Student> students = studentRepository.findAll();
	    Map<String, Object> response = new LinkedHashMap<String, Object>();
	    response.put("totalStudents", students.size());
	    response.put("books", students);
	    return response;
	  
  }
}