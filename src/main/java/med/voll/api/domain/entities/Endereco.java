package med.voll.api.domain.entities;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.domain.dtos.endereco.DadosEndereco;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {
    private String logradouro;
    private String bairro;
    private String cep;
    private String numero;
    private String complemento;
    private String uf;
    private String cidade;

    public Endereco(DadosEndereco dados) {
        this.logradouro = dados.logradouro();
        this.bairro = dados.bairro();
        this.cep = dados.cep();
        this.numero = dados.numero();
        this.complemento = dados.complemento();
        this.uf = dados.uf();
        this.cidade = dados.cidade();
    }

    public void atualizarInformacoes(DadosEndereco dados) {
        if(this.logradouro != null) this.logradouro = dados.logradouro();
        if(this.bairro != null) this.bairro = dados.bairro();
        if(this.cep != null) this.cep = dados.cep();
        if(this.numero != null) this.numero = dados.numero();
        if(this.complemento != null) this.complemento = dados.complemento();
        if(this.uf != null) this.uf = dados.uf();
        if(this.cidade != null) this.cidade = dados.cidade();
    }
}
