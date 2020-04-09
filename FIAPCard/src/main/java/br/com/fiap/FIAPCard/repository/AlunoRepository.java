package br.com.fiap.FIAPCard.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.fiap.FIAPCard.entity.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Integer>{

    Page<Aluno> findAll(Pageable pageable);

    @Query("from Aluno a where a.nome like %:nome%")
    List<Aluno> findByNome(@Param("nome") String nome);
    
    @Query("from Aluno a where a.rm = :rm")
    Aluno findByRm(@Param("rm") Integer rm);

}
