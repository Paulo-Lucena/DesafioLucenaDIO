package com.cadastrofuncionario.CadastroDeFuncionarios.dto.request;

import com.cadastrofuncionario.CadastroDeFuncionarios.enums.NomesDepartamento;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DepartamentoDTO {

        private Long id;

        @Enumerated(EnumType.STRING)
        @NotEmpty
        private NomesDepartamento nome;


}

