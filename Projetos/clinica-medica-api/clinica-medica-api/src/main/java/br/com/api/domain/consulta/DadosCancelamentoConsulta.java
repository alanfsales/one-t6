package br.com.api.domain.consulta;

import br.com.api.domain.medico.Especialidade;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DadosCancelamentoConsulta(

        @NotNull
        Long idConsulta,

        @NotBlank
        String motivo
      ) {
}