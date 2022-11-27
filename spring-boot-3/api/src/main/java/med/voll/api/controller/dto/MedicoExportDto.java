package med.voll.api.controller.dto;

import med.voll.api.model.Especialidade;
import med.voll.api.model.Medico;

public record MedicoExportDto(String nome, String email, String crm, Especialidade especialidade) {

    public MedicoExportDto(Medico medico) {
        this(medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade());
    }
}
