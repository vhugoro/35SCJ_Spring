package br.com.fiap.FIAPCard.dto;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Date;

import br.com.fiap.FIAPCard.entity.Aluno;

public class AlunoDTO {

    private Integer id;
    private String nome;
	private Integer rm;
    private ZonedDateTime dataCriacao;
    private ZonedDateTime dataAtualizacao;

    public AlunoDTO(){}

    public AlunoDTO(Integer id, String nome, Integer rm) {
        this.id = id;
        this.nome = nome;
        this.rm = rm;
    }

    public AlunoDTO(Aluno aluno) {
        this.id = aluno.getId();
        this.nome = aluno.getNome();
        this.rm = aluno.getRm();
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
	
	public Integer getRm() {
		return rm;
	}

	public void setRm(Integer rm) {
		this.rm = rm;
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
