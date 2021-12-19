package com.spring.jpah2.Controller;

import java.util.List;
import java.util.Optional;

import com.spring.jpah2.Model.Student;
import com.spring.jpah2.Service.StudentService;
import com.spring.jpah2.Utils.GlobalErrorResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
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
  ResponseEntity<?> getStudentById(@PathVariable Integer registration) {
    Optional<Student> fetchedStudent;
    try {
      fetchedStudent = this.student.getStudentById(registration);
    } catch (Exception e) {
      GlobalErrorResponse errorDetails = new GlobalErrorResponse("Id not found", "Can not update item because id does not exist");
      return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

    return ResponseEntity.ok(fetchedStudent);
  }

  @RequestMapping(value = "/student", method = RequestMethod.POST)
  ResponseEntity<?> createStudent(@RequestBody Student requestStudent) {
    return new ResponseEntity<>(this.student.createStudent(requestStudent), HttpStatus.CREATED);
  }

  @RequestMapping(value = "/student/{registration}", method = RequestMethod.PATCH)
  ResponseEntity<?> updateStudent(@PathVariable Integer registration, @RequestBody Student requestStudent) {
    Student updatedStudent;
    try {
      updatedStudent = this.student.updateStudent(registration, requestStudent);
    } catch (Exception e) {
      GlobalErrorResponse errorDetails = new GlobalErrorResponse("Id not found", "Can not update item because id does not exist");
      return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

    return ResponseEntity.ok(updatedStudent);
  }
}
