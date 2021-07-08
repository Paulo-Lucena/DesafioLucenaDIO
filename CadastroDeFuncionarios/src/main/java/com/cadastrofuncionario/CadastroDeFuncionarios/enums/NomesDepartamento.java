package com.cadastrofuncionario.CadastroDeFuncionarios.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum NomesDepartamento {

    ADMINISTRATIVO("Administrativo"),
    MARKETING ("Marketing"),
    JURIDICO ("Juridico"),
    DEPARTAMENTOPESSOAL ("Departamento Pessoal"),
    RECURSOSHUMANOS ("Recusos Humanos"),
    COBRANCA ("Cobranca");

    private final String descricao;

}
