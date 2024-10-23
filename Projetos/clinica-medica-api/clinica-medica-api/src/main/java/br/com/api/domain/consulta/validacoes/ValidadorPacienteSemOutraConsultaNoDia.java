package br.com.api.domain.consulta.validacoes;

import br.com.api.domain.ValidacaoException;
import br.com.api.domain.consulta.ConsultaRepository;
import br.com.api.domain.consulta.DadosAgendamentoConsulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorPacienteSemOutraConsultaNoDia implements ValidadorAgendamentoDeConsulta {

    @Autowired
    private ConsultaRepository repository;

    public void validar(DadosAgendamentoConsulta dados){
        var primeiroHorario = dados.data().withHour(7);
        var ultimoHorario = dados.data().withHour(18);
        var pacientePossuiUmaConsultaNoDia = repository.
                existsByPacienteIdAndDataBetween(dados.idPaciente(), primeiroHorario, ultimoHorario);

        if(pacientePossuiUmaConsultaNoDia){
            throw new ValidacaoException("Paciente já possui uma consulta para esse dia");
        }
    }
}
