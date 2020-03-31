package br.com.fiap.FIAPCard.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.fiap.FIAPCard.entity.Aluno;

import java.util.List;

public interface AlunoRepository extends JpaRepository<Aluno, Integer>{

    Page<Aluno> findAll(Pageable pageable);

    @Query("from Aluno a where a.nome like %:nome%")
    List<Aluno> findPorNome(String nome);
    
    @Query("from Aluno a where a.rm = :rm")
    Aluno findPorRm(Integer rm);

}
