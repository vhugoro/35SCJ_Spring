package br.com.fiap.FIAPCard.service;

import java.util.List;

import br.com.fiap.FIAPCard.dto.AlunoDTO;

public interface AlunoService {

    List<AlunoDTO> findAll();
    AlunoDTO findById(Integer id);
    AlunoDTO findByRm(Integer rm);
    List<AlunoDTO> findByNome(String nome);
    AlunoDTO create(AlunoDTO alunoDTO);
    AlunoDTO update(Integer id, AlunoDTO alunoDTO);
    void delete(Integer id);

}
