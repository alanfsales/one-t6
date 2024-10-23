package br.com.api.domain.paciente;

import br.com.api.domain.endereco.DadosEndereco;

public record DadosAtualizaçãoPaciente(
        Long id,
        String nome,
        String telefone,
        DadosEndereco endereco) {
}
