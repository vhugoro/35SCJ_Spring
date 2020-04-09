package br.com.fiap.FIAPCard.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.fiap.FIAPCard.dto.AlunoDTO;
import br.com.fiap.FIAPCard.entity.Aluno;
import br.com.fiap.FIAPCard.repository.AlunoRepository;
import br.com.fiap.FIAPCard.service.AlunoService;

@Service
public class AlunoServiceImpl implements AlunoService {
	
	@Autowired
    private AlunoRepository alunoRepository;

    @Override
    public List<AlunoDTO> findAll() {
        List<Aluno> alunoList;
        
        alunoList = alunoRepository.findAll();

        return alunoList
                .stream()
                .map(AlunoDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public AlunoDTO findById(Integer id) {
        return saveAndGetAlunoDTO(getAluno(id));
    }
    
    @Override
    public AlunoDTO findByRm(Integer rm) {
    	return new AlunoDTO(this.alunoRepository.findPorRm(rm));
    }

    private Aluno getAluno(Integer id) {
        return alunoRepository.findById(id)
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public AlunoDTO create(AlunoDTO alunoDTO) {
        Aluno aluno = new Aluno(alunoDTO);

        return saveAndGetAlunoDTO(aluno);
    }

    @Override
    public AlunoDTO update(Integer id, AlunoDTO alunoDTO) {
        Aluno aluno =  getAluno(id);
        
        aluno.setNome(alunoDTO.getNome());
        aluno.setRm(alunoDTO.getRm());
        
        return saveAndGetAlunoDTO(aluno);
    }

    private AlunoDTO saveAndGetAlunoDTO(Aluno aluno) {
        Aluno savedAluno = alunoRepository.save(aluno);
        return new AlunoDTO(savedAluno);
    }

    @Override
    public void delete(Integer id) {
        Aluno aluno = getAluno(id);
        alunoRepository.delete(aluno);
    }
}
