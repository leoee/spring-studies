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

  public Student updateStudent(Integer registration, Student requestStudent) throws Exception {
    Optional<Student> fetchedStudent = this.student.findById(registration);
    if (fetchedStudent == null) {
      throw new RuntimeException("Id not found");
    }

    Student newStudent = new Student();
    newStudent.setCourse(requestStudent.getCourse() != null ? requestStudent.getCourse() : fetchedStudent.get().getCourse());
    newStudent.setName(requestStudent.getName() != null ? requestStudent.getName() : fetchedStudent.get().getName());
    newStudent.setRegistration(registration);

    return this.student.save(newStudent);
  }
}
