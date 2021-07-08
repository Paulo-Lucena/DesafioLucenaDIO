package com.cadastrofuncionario.CadastroDeFuncionarios.dto.request;

import com.cadastrofuncionario.CadastroDeFuncionarios.entity.Departamento;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FuncionarioDTO {


    private Long id;

    @NotEmpty
    @Size(min = 2, max= 9999)
    private String nome;

    @NotEmpty
    @CPF
    private String cpf;

    private String datanascimento;

    private String dataContratacao;

    private String datadesligamento;

    @Valid
    @NotEmpty
    private List<DepartamentoDTO> setores;
}
