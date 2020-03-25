package br.com.fiap.FIAPCard.dto;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Date;

import br.com.fiap.FIAPCard.entity.Aluno;

public class AlunoDTO {

    private Integer id;
    private String nome;
	private Integer rm;
    private Integer numeroCartao;
    private Integer digitoVerificadorCartao;
    private ZonedDateTime dataCriacao;
    private ZonedDateTime dataAtualizacao;

    public AlunoDTO(){}

    public AlunoDTO(Integer id, String nome, Integer rm, Integer numeroCartao, Integer digitoVerificadorCartao) {
        this.id = id;
        this.nome = nome;
        this.rm = rm;
        this.numeroCartao = numeroCartao;
        this.digitoVerificadorCartao = digitoVerificadorCartao;
    }

    public AlunoDTO(Aluno aluno) {
        this.id = aluno.getId();
        this.nome = aluno.getNome();
        this.rm = aluno.getRm();
        this.numeroCartao = aluno.getNumeroCartao();
        this.digitoVerificadorCartao = aluno.getDigitoVerificadorCartao();
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

	public Integer getNumeroCartao() {
		return numeroCartao;
	}

	public void setNumeroCartao(Integer numeroCartao) {
		this.numeroCartao = numeroCartao;
	}

	public Integer getDigitoVerificadorCartao() {
		return digitoVerificadorCartao;
	}

	public void setDigitoVerificadorCartao(Integer digitoVerificadorCartao) {
		this.digitoVerificadorCartao = digitoVerificadorCartao;
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
