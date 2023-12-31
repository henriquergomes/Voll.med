package med.voll.api.Models;
import jakarta.persistence.*;
import lombok.*;
import med.voll.api.Records.DadosEndereco;
@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {
    private String logradouro;
    private String bairro;
    private String cep;
    private String cidade;
    private String uf;
    private String complemento;
    private String numero;

    public Endereco(DadosEndereco dados) {
        this.logradouro = dados.logradouro();
        this.bairro = dados.bairro();
        this.cep = dados.cep();
        this.cidade = dados.cidade();
        this.uf = dados.uf();
        this.complemento = dados.complemento();
        this.numero = dados.numero();
    }

    public void UpdateEndereco(DadosEndereco dados) {
        if (dados.logradouro() != null)
            this.logradouro = dados.logradouro();
        if (dados.bairro() != null)
            this.bairro = dados.bairro();
        if (dados.cep() != null)
            this.cep = dados.cep();
        if (dados.cidade() != null)
            this.cidade = dados.cidade();
        if (dados.uf() != null)
            this.uf = dados.uf();
        if (dados.complemento() != null)
            this.complemento = dados.complemento();
        if (dados.numero() != null)
            this.numero = dados.numero();
    }
}
