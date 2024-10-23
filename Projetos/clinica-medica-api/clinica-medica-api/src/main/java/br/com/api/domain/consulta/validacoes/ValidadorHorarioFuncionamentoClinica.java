package br.com.api.domain.consulta.validacoes;

import br.com.api.domain.ValidacaoException;
import br.com.api.domain.consulta.DadosAgendamentoConsulta;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;

@Component
public class ValidadorHorarioFuncionamentoClinica implements ValidadorAgendamentoDeConsulta{

    public void validar(DadosAgendamentoConsulta dados){
        var dataConsulta = dados.data();

        var domingo = dataConsulta.getDayOfWeek().equals(DayOfWeek.SUNDAY);
        var antesAberturaDaClinica = dataConsulta.getHour() < 7;
        var depoisEncerramnetoDaClinica = dataConsulta.getHour() > 18;

        if (domingo || antesAberturaDaClinica || depoisEncerramnetoDaClinica){
            throw new ValidacaoException("Consulta fora do horário de funcionamento");
        }

    }
}
