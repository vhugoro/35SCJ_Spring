package br.com.fiap.FIAPCard.dto;

import java.math.BigDecimal;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Date;

import br.com.fiap.FIAPCard.entity.Aluno;
import br.com.fiap.FIAPCard.entity.Transacao;

public class TransacaoDTO {
	
    private Integer id;
	private Aluno aluno;
	private Autorizadora autorizadora;
	private BigDecimal valor;
	private ZonedDateTime data;
	
	public TransacaoDTO(Transacao transacao) {
        this.id = transacao.getId();
        this.aluno = transacao.getAluno();
        this.autorizadora = transacao.getAutorizadora();
        this.valor = transacao.getValor();
        this.data = convertToZonedDateTime(transacao.getData());
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

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Autorizadora getAutorizadora() {
		return autorizadora;
	}

	public void setAutorizadora(Autorizadora autorizadora) {
		this.autorizadora = autorizadora;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public ZonedDateTime getData() {
		return data;
	}

	public void setData(ZonedDateTime data) {
		this.data = data;
	}
    
}
