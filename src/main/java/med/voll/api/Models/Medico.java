package med.voll.api.Models;
import jakarta.persistence.*;
import lombok.*;
import med.voll.api.Records.DadosCadastroMedicos;

import med.voll.api.Records.DadosUpdateMedico;
import med.voll.api.enums.Especialidade;

@Table(name = "medico")
@Entity(name = "Medico")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Medico {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String crm;
    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;
    @Embedded
    private Endereco endereco;
    private Boolean ativo;

    public Medico(DadosCadastroMedicos dados) {
        this.nome = dados.nome();
        this.email = dados.email();
        this.telefone = dados.telefone();
        this.especialidade = dados.especialidade();
        this.crm = dados.crm();
        this.endereco = new Endereco(dados.endereco());
        this.ativo = true;
    }

    public void UpdateMedico(DadosUpdateMedico dados) {
        if (dados.nome() != null)
            this.nome = dados.nome();
        if (dados.email() != null)
            this.email = dados.email();
        if (dados.telefone() != null)
            this.telefone = dados.telefone();
        if (dados.crm() != null)
            this.crm = dados.crm();
        if (dados.especialidade() != null)
            this.especialidade = dados.especialidade();
        if (dados.endereco() != null)
            this.endereco.UpdateEndereco(dados.endereco());
    }

    public void Delete(Long id) {
        this.ativo = false;
    }
}
