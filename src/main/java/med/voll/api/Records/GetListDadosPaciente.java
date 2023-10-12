package med.voll.api.Records;

import med.voll.api.Models.Paciente;

public record GetListDadosPaciente(
        String nome,
        String email,
        String cpf,
        String telefone
) {
    public GetListDadosPaciente(Paciente paciente) {
        this(paciente.getNome(), paciente.getEmail(), paciente.getCpf(), paciente.getTelefone());
    }
}
