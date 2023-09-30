package med.voll.api.domain.dtos.medico;

import jakarta.validation.constraints.NotNull;
import med.voll.api.domain.dtos.endereco.DadosEndereco;

public record DadosAtualizacaoMedico(
        @NotNull
        Long id,
        String nome,
        String telefone,
        DadosEndereco endereco

) {
}
