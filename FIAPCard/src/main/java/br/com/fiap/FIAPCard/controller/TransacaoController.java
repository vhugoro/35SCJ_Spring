package br.com.fiap.FIAPCard.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.FIAPCard.dto.AlunoDTO;
import br.com.fiap.FIAPCard.dto.TransacaoDTO;
import br.com.fiap.FIAPCard.entity.Aluno;
import br.com.fiap.FIAPCard.service.AlunoService;
import br.com.fiap.FIAPCard.service.TransacaoService;

@RestController
@RequestMapping("transacoes")
public class TransacaoController {
	
	@Autowired
	private TransacaoService serviceTransacao;
	
	@Autowired
	private AlunoService serviceAluno;
	
	@GetMapping
	public List<TransacaoDTO> getAll(){
		return serviceTransacao.findAll();
	}
	
	@GetMapping("{rmAluno}")
	public List<TransacaoDTO> findByAluno(@PathVariable Integer rmAluno) {
		AlunoDTO alunoDTO = this.serviceAluno.findByRm(rmAluno);
		return this.serviceTransacao.findByAluno(new Aluno(alunoDTO));
	}
	
	@PostMapping
    @ResponseStatus(HttpStatus.CREATED)
	public TransacaoDTO create(@RequestBody @Valid TransacaoDTO transacaoDTO) {
		return this.serviceTransacao.create(transacaoDTO);
	}
	
	@DeleteMapping("{id}")
    public void delete(@PathVariable Integer id){
        this.serviceTransacao.delete(id);
    }

}
