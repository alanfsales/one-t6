package br.com.api.domain.consulta.validacoes;

import br.com.api.domain.ValidacaoException;
import br.com.api.domain.consulta.DadosAgendamentoConsulta;
import br.com.api.domain.paciente.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorPacienteAtivo implements ValidadorAgendamentoDeConsulta {

    @Autowired
    private PacienteRepository repository;

    public void validar(DadosAgendamentoConsulta dados){
        var pacienteEstaAtivo = repository.findAtivoById(dados.idPaciente());

        if(!pacienteEstaAtivo){
            throw new ValidacaoException("Concuta não pode ser agendada com paciente excluído");
        }
    }
}
