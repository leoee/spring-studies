package com.spring.jpah2.Repository;

import com.spring.jpah2.Model.Student;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
  
}
