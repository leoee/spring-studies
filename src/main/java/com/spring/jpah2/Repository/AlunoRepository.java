package com.spring.jpah2.Repository;

import com.spring.jpah2.Model.Aluno;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Integer> {
  
}
