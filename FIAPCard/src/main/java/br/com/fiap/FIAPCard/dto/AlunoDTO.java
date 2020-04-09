package br.com.fiap.FIAPCard.dto;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Date;

import br.com.fiap.FIAPCard.entity.Aluno;

public class AlunoDTO {

    private Integer id;
    private String nome;
	private Integer rm;

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
    
}
