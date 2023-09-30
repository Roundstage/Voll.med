package med.voll.api.domain.dtos.pacientes;

import jakarta.validation.Valid;
import med.voll.api.domain.dtos.endereco.DadosEndereco;

public record DadosAtualizacaoPaciente(
        Long id,
        String nome,
        String telefone,
        @Valid DadosEndereco endereco
) {
}