package br.com.fiap.FIAPCard.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import br.com.fiap.FIAPCard.dto.AlunoDTO;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "TB_ALUNO")
@EntityListeners(AuditingEntityListener.class)
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String nome;

    @Column
    private Integer rm;

    @Column
    private Integer numeroCartao;

    @Column
    private Integer digitoVerificadorCartao;

    @Column(name = "created_date")
    @CreatedDate
    private Date dataCriacao;

    @Column(name = "updated_date")
    @LastModifiedDate
    private Date dataAtualizacao;

    public Aluno(){}

    public Aluno(AlunoDTO alunoDTO) {
        this.nome = alunoDTO.getNome();
        this.rm = alunoDTO.getRm();
        this.numeroCartao = alunoDTO.getNumeroCartao();
        this.digitoVerificadorCartao = alunoDTO.getDigitoVerificadorCartao();
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

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Date getDataAtualizacao() {
		return dataAtualizacao;
	}

	public void setDataAtualizacao(Date dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}
}
