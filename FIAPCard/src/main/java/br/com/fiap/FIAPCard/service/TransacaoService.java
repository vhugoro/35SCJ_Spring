package br.com.fiap.FIAPCard.service;

import java.util.List;

import br.com.fiap.FIAPCard.dto.TransacaoDTO;
import br.com.fiap.FIAPCard.entity.Aluno;

public interface TransacaoService {
	
	List<TransacaoDTO> findAll();
    List<TransacaoDTO> findByAluno(Aluno aluno);
    TransacaoDTO create(TransacaoDTO transacaoDTO);
    void delete(Integer id);

}
