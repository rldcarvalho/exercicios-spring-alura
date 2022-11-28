package med.voll.api.controller.dto;

import med.voll.api.model.Paciente;

public record PacienteExportDto(String nome, String email, String cpf) {

    public PacienteExportDto(Paciente paciente){
        this(paciente.getNome(), paciente.getEmail(), paciente.getCpf());
    }
}
