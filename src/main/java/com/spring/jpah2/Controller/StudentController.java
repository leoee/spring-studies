package com.spring.jpah2.Controller;

import java.util.List;
import java.util.Optional;

import com.spring.jpah2.Model.Student;
import com.spring.jpah2.Service.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
  @Autowired
  private StudentService student;

  @RequestMapping(value = "/student", method = RequestMethod.GET)
  List<Student> getAllStudents() {
    return this.student.getAllStudents();
  }

  @RequestMapping(value = "/student/{registration}", method = RequestMethod.GET)
  Optional<Student> getStudentById(Integer registration) {
    return this.student.getStudentById(registration);
  }

  @RequestMapping(value = "/student", method = RequestMethod.POST)
  ResponseEntity<?> createStudent(@RequestBody Student requestStudent) {
    return new ResponseEntity<>(this.student.createStudent(requestStudent), HttpStatus.CREATED);
  }
}
