package com.cadastrofuncionario.CadastroDeFuncionarios.controller;

import com.cadastrofuncionario.CadastroDeFuncionarios.dto.request.FuncionarioDTO;
import com.cadastrofuncionario.CadastroDeFuncionarios.dto.response.MessageResponseDTO;
import com.cadastrofuncionario.CadastroDeFuncionarios.entity.Funcionario;
import com.cadastrofuncionario.CadastroDeFuncionarios.exception.FuncionarioNotFoundException;
import com.cadastrofuncionario.CadastroDeFuncionarios.service.CadastroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping ("/api/cadastro/funcionario")
public class CadastroController {

    private CadastroService cadastroService;

    @Autowired
    public CadastroController(CadastroService cadastroService){
        this.cadastroService = cadastroService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO criarFuncionario(@RequestBody @Valid FuncionarioDTO funcionarioDTO){
    return cadastroService.criarFuncionario(funcionarioDTO);
    }

    @GetMapping
    public List<FuncionarioDTO> listAll(){
    return cadastroService.listAll();
    }

    @GetMapping("/{id}")
    public FuncionarioDTO findById(@PathVariable Long id) throws FuncionarioNotFoundException {
        return cadastroService.findById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) throws FuncionarioNotFoundException {
        cadastroService.delete(id);
    }
    @PutMapping("/{id}")
    public  MessageResponseDTO updateById(@PathVariable Long id,@RequestBody @Valid FuncionarioDTO funcionarioDTO) throws FuncionarioNotFoundException {
    return  cadastroService.updateById(id, funcionarioDTO);
    }
}
