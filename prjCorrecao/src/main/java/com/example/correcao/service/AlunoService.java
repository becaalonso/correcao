package com.example.correcao.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;

import com.example.correcao.entities.Aluno;
import com.example.correcao.repository.AlunoRepository;

public class AlunoService {

    private final AlunoRepository alunoRepository;
    
    @Autowired
    public AlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    public List<Aluno> getAllAlunos() {
        return alunoRepository.findAll();
    }

    public Aluno getAlunoById(Long id) {
        Optional<Aluno> aluno = alunoRepository.findById(id);
        return aluno.orElse(null);
    }
    @Query 
    public List<Aluno> buscarAlunosPorCidade(String cidade) {
        return alunoRepository.findByCidade(cidade); 
      }
    @Query  
    public List<Aluno> buscarAlunosPorNomeERenda(String nome, Double renda) {
        return alunoRepository.findByNomeAndRenda(nome,renda); 
      }
    @Query 
    public List<Aluno> buscarAlunosPorNome(String nome) {
        return alunoRepository.findByCidade(nome); 
      }
  //Query Method 
    public List<Aluno> buscarCidadeERenda(String cidade, Double renda) {
        return alunoRepository.findByNomeAndRenda(cidade,renda); 
      }
  @Query
    public List<Aluno> findByNome(String nome) {
        return alunoRepository.findByCidade(nome);
    }
  @Query
    public List<Aluno> findByNomeCompletoLike(String nomeCompleto) {
        return alunoRepository.findByCidade(nomeCompleto);
    }
   @Query
    public List<Aluno> findByTurmaId(Long turmaId) {
        return alunoRepository.findByTurmaId(turmaId);
    }

    public Aluno salvarAluno(Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    public Aluno updateAluno(Long id, Aluno updatedAluno) {
        Optional<Aluno> existingAluno = alunoRepository.findById(id);
        if (existingAluno.isPresent()) {
            updatedAluno.setId(id);
            return alunoRepository.save(updatedAluno);
        }
        return null;
    }

    public boolean deleteAluno(Long id) {
        Optional<Aluno> existingAluno = alunoRepository.findById(id);
        if (existingAluno.isPresent()) {
            alunoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
	

