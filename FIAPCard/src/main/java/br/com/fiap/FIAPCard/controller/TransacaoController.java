package br.com.fiap.FIAPCard.controller;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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

	@GetMapping(value="/get-file",
			produces = MediaType.APPLICATION_OCTET_STREAM_VALUE
			)
	public @ResponseBody byte[] getFileExtrato() throws IOException {
		final List<TransacaoDTO> trans = serviceTransacao.findAll();
		
		try {
			FileWriter arquivo = new FileWriter(new File("extrato.txt"));
			PrintWriter gravarArq = new PrintWriter(arquivo);
			trans.stream().forEach(t -> {
				gravarArq.println(t.toString());
			});
			arquivo.close();
		}catch (IOException e) {
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	    return Files.readAllBytes(Paths.get("extrato.txt"));
	}
	
	@GetMapping(value="/get-file/rm/{rm}",
			produces = MediaType.APPLICATION_OCTET_STREAM_VALUE
			)
	public @ResponseBody byte[] getFileExtratoByRmAluno(@PathVariable Integer rm) throws IOException {
		Aluno aluno = new Aluno(serviceAluno.findByRm(rm));
		List<TransacaoDTO> trans = serviceTransacao.findByAluno(aluno);
		
		try {
			FileWriter arquivo = new FileWriter(new File("extratoUser.txt"));
			PrintWriter gravarArq = new PrintWriter(arquivo);
			trans.stream().forEach(t -> {
					gravarArq.println(t.toString());
			});
			arquivo.close();
		}catch (IOException e) {
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}

	    return Files.readAllBytes(Paths.get("extratoUser.txt"));
	}
}