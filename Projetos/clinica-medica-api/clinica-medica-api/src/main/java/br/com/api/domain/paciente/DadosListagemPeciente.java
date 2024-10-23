package br.com.api.domain.paciente;

public record DadosListagemPeciente(
        Long id,
        String nome,
        String email,
        String cpf) {

    public DadosListagemPeciente(Paciente paciente){
        this(paciente.getId(), paciente.getNome(), paciente.getEmail(), paciente.getCpf());
    }
}
