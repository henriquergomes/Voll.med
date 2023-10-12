package med.voll.api.Records;

import med.voll.api.Models.Medico;
import med.voll.api.enums.Especialidade;

public record GetListDadosMedicos(
        Long id,
        String nome,
        String email,
        String crm,
        String telefone,
        Especialidade especialidade
) {
    public GetListDadosMedicos(Medico medico) {
        this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getTelefone(), medico.getEspecialidade());
    }
}
