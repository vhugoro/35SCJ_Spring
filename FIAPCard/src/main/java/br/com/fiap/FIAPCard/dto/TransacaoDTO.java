package br.com.fiap.FIAPCard.dto;

import java.math.BigDecimal;

import br.com.fiap.FIAPCard.entity.Aluno;
import br.com.fiap.FIAPCard.entity.Transacao;

public class TransacaoDTO {
	
    private Integer id;
	private Aluno aluno;
	private Autorizadora autorizadora;
	private BigDecimal valor;
	
	public TransacaoDTO(Transacao transacao) {
        this.id = transacao.getId();
        this.aluno = transacao.getAluno();
        this.autorizadora = transacao.getAutorizadora();
        this.valor = transacao.getValor();
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
    
}
