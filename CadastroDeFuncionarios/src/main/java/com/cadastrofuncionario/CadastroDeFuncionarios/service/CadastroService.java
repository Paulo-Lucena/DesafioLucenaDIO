package com.cadastrofuncionario.CadastroDeFuncionarios.service;

import com.cadastrofuncionario.CadastroDeFuncionarios.dto.request.FuncionarioDTO;
import com.cadastrofuncionario.CadastroDeFuncionarios.dto.response.MessageResponseDTO;
import com.cadastrofuncionario.CadastroDeFuncionarios.entity.Funcionario;
import com.cadastrofuncionario.CadastroDeFuncionarios.exception.FuncionarioNotFoundException;
import com.cadastrofuncionario.CadastroDeFuncionarios.mapper.FuncionarioMapper;
import com.cadastrofuncionario.CadastroDeFuncionarios.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CadastroService {

    private FuncionarioRepository funcionarioRepository;

    private final FuncionarioMapper funcionarioMapper = FuncionarioMapper.INSTANTCE;

    @Autowired
    public  CadastroService(FuncionarioRepository funcionarioRepository){
        this.funcionarioRepository = funcionarioRepository;
    }

    public void delete(Long id) throws FuncionarioNotFoundException {
    funcionarioRepository.findById(id)
            .orElseThrow(() -> new FuncionarioNotFoundException(id));

        funcionarioRepository.deleteById(id);
    }

    public List<FuncionarioDTO> listAll() {
        List<Funcionario> allPeople = funcionarioRepository.findAll();
        return allPeople.stream()
                .map(funcionarioMapper::toDTO)
                .collect(Collectors.toList());
    }

    public MessageResponseDTO criarFuncionario(FuncionarioDTO funcionarioDTO){
        Funcionario salvarFuncionario = funcionarioMapper.toModel(funcionarioDTO);

        Funcionario savedFuncionario =  funcionarioRepository.save(salvarFuncionario);
        return MessageResponseDTO.builder()
                .message("Funcionario Cadastrado!" +savedFuncionario.getId())
                .build();
    }

    public FuncionarioDTO findById(Long id) throws FuncionarioNotFoundException {
        Funcionario funcionario = funcionarioRepository.findById(id)
                .orElseThrow(() -> new FuncionarioNotFoundException(id));
                return funcionarioMapper.toDTO(funcionario);
    }

    public MessageResponseDTO updateById(Long id, FuncionarioDTO funcionarioDTO) throws FuncionarioNotFoundException {
        verifyIfExists(id);

        Funcionario salvarFuncionario = funcionarioMapper.toModel(funcionarioDTO);

        Funcionario savedFuncionario =  funcionarioRepository.save(salvarFuncionario);
        return MessageResponseDTO.builder()
                .message("Funcionario Cadastrado!" +savedFuncionario.getId())
                .build();
    }

    private Funcionario verifyIfExists (Long id) throws FuncionarioNotFoundException{
        return funcionarioRepository.findById(id)
                .orElseThrow(() -> new FuncionarioNotFoundException(id));
    }


}
