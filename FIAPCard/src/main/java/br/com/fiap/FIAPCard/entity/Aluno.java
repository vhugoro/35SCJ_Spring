package br.com.fiap.FIAPCard.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import br.com.fiap.FIAPCard.dto.AlunoDTO;

@Entity
@Table(name = "TB_ALUNO")
@EntityListeners(AuditingEntityListener.class)
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private Integer rm;
    
    @Column
    private String nome;
    
    public Aluno(){}

    public Aluno(AlunoDTO alunoDTO) {
    	this.id = alunoDTO.getId();
        this.nome = alunoDTO.getNome();
        this.rm = alunoDTO.getRm();
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
		return this.rm;
	}

	public void setRm(Integer rm) {
		this.rm = rm;
	}
	
}
