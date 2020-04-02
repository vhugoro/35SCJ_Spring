package br.com.fiap.FIAPCard.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.fiap.FIAPCard.entity.Aluno;
import br.com.fiap.FIAPCard.entity.Transacao;

public interface TransacaoRepository extends JpaRepository<Transacao, Integer> {
	
	Page<Transacao> findAll(Pageable pageable);
	
	@Query("from Transacao t where t.aluno = :aluno")
	List<Transacao> findByAluno(Aluno aluno);

}
