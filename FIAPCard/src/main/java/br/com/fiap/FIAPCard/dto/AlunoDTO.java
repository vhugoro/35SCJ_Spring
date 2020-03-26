package br.com.fiap.FIAPCard.dto;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Date;

import br.com.fiap.FIAPCard.entity.Aluno;

public class AlunoDTO {

    private Integer id;
    private String nome;
	private Long cpf;
    private ZonedDateTime dataCriacao;
    private ZonedDateTime dataAtualizacao;

    public AlunoDTO(){}

    public AlunoDTO(Integer id, String nome, Long cpf) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
    }

    public AlunoDTO(Aluno aluno) {
        this.id = aluno.getId();
        this.nome = aluno.getNome();
        this.cpf = aluno.getCpf();
        this.dataCriacao = convertToZonedDateTime(aluno.getDataCriacao());
        this.dataAtualizacao = convertToZonedDateTime(aluno.getDataAtualizacao());
    }

    private ZonedDateTime convertToZonedDateTime(Date dataAtualizacao) {
        if(dataAtualizacao != null){
            return ZonedDateTime.ofInstant(dataAtualizacao.toInstant(), ZoneOffset.systemDefault());
        } else {
            return null;
        }
    }

    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Long getCpf() {
		return cpf;
	}

	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}

	public ZonedDateTime getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(ZonedDateTime dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public ZonedDateTime getDataAtualizacao() {
		return dataAtualizacao;
	}

	public void setDataAtualizacao(ZonedDateTime dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}
    
}
