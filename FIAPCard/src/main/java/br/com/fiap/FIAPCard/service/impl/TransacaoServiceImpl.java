package br.com.fiap.FIAPCard.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.FIAPCard.dto.TransacaoDTO;
import br.com.fiap.FIAPCard.entity.Aluno;
import br.com.fiap.FIAPCard.entity.Transacao;
import br.com.fiap.FIAPCard.repository.TransacaoRepository;
import br.com.fiap.FIAPCard.service.TransacaoService;

@Service
public class TransacaoServiceImpl implements TransacaoService {
	
	@Autowired
	private TransacaoRepository repository;

	@Override
	public List<TransacaoDTO> findAll() {
		List<Transacao> transacoes = this.repository.findAll();
		
		return transacoes.stream()
						 .map(t -> new TransacaoDTO(t))
						 .collect(Collectors.toList());
	}

	@Override
	public List<TransacaoDTO> findByAluno(Aluno aluno) {
		List<Transacao> transacoes = this.repository.findByAluno(aluno);
		
		return transacoes.stream()
				 .map(t -> new TransacaoDTO(t))
				 .collect(Collectors.toList());
	}

	@Override
	public TransacaoDTO create(TransacaoDTO transacaoDTO) {
		Transacao transacao = new Transacao(transacaoDTO);
		return saveAndGetTransacaoDTO(transacao);
	}
	
	@Override
	public void delete(Integer id) {
		this.repository.deleteById(id);
	}
	
	private TransacaoDTO saveAndGetTransacaoDTO(Transacao transacao) {
		Transacao transacaoSalva = this.repository.saveAndFlush(transacao);
		return new TransacaoDTO(transacaoSalva);
	}

}
