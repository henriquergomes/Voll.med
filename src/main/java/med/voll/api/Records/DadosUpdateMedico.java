package med.voll.api.Records;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.enums.Especialidade;

public record DadosUpdateMedico(
        @NotNull
        Long id,
        String nome,
        String email,
        String telefone,
        @Pattern(regexp="\\d{4,6}")
        String crm,
        Especialidade especialidade,
        DadosEndereco endereco
) {
}
