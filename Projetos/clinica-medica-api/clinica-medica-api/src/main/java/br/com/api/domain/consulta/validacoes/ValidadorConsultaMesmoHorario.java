package br.com.api.domain.consulta.validacoes;

import br.com.api.domain.ValidacaoException;
import br.com.api.domain.consulta.ConsultaRepository;
import br.com.api.domain.consulta.DadosAgendamentoConsulta;
import br.com.api.domain.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorConsultaMesmoHorario implements ValidadorAgendamentoDeConsulta {

    @Autowired
    private ConsultaRepository repository;

    public void validar(DadosAgendamentoConsulta dados){
        var medicoPossuiOutraCOnsulta = repository.existsByMedicoIdAndData(dados.idMedico(), dados.data());
        if (medicoPossuiOutraCOnsulta){
            throw new ValidacaoException("Médico já possui outra consulta nesse horário ");
        }
    }
}
