package com.spring.jpah2.Service;

import java.util.List;
import java.util.Optional;

import com.spring.jpah2.Model.Student;
import com.spring.jpah2.Repository.StudentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
  @Autowired
  private StudentRepository student;

  public List<Student> getAllStudents() {
    return this.student.findAll();
  }

  public Optional<Student> getStudentById(Integer registration) {
    return this.student.findById(registration);
  }

  public Student createStudent(Student requestStudent) {
    return this.student.save(requestStudent);
  }
}
