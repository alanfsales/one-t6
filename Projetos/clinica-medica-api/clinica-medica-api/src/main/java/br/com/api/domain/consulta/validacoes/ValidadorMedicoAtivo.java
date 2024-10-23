package br.com.api.domain.consulta.validacoes;

import br.com.api.domain.ValidacaoException;
import br.com.api.domain.consulta.DadosAgendamentoConsulta;
import br.com.api.domain.medico.Medico;
import br.com.api.domain.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;

@Component
public class ValidadorMedicoAtivo implements ValidadorAgendamentoDeConsulta {

    @Autowired
    private MedicoRepository repository;

    public void validar(DadosAgendamentoConsulta dados){
        if (dados.idMedico() == null){
            return;
        }

        var medicoEstaAtivo = repository.findAtivoById(dados.idMedico());

        if(!medicoEstaAtivo){
            throw new ValidacaoException("Concuta não pode ser agendada com médico excluído");
        }

    }
}
