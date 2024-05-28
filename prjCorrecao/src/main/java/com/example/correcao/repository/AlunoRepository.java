package com.example.correcao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.correcao.entities.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
	
	List<Aluno> findByCidade(String cidade);
	Aluno findByRa(String ra);
	List<Aluno> findByNomeAndRenda(String nome, Double renda);

	
}
