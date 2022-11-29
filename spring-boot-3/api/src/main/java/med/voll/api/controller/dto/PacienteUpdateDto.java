package med.voll.api.controller.dto;

import jakarta.validation.constraints.NotNull;

public record PacienteUpdateDto(@NotNull Long id, String nome, String telefone, EnderecoDto endereco) {
}
