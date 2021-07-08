package com.cadastrofuncionario.CadastroDeFuncionarios.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class FuncionarioNotFoundException extends Exception {
    public FuncionarioNotFoundException(Long id) {
        super("Funcionário com o ID " + id);

    }
}
