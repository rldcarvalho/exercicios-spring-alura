package med.voll.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.controller.dto.PacienteDto;
import med.voll.api.controller.dto.PacienteExportDto;
import med.voll.api.controller.dto.PacienteUpdateDto;
import med.voll.api.model.Paciente;
import med.voll.api.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteRepository pacienteRepository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid PacienteDto dados){
        pacienteRepository.save(new Paciente(dados));
    }

    @GetMapping
    public Page<PacienteExportDto> listar(@PageableDefault(size = 10, sort = "nome") Pageable paginacao){
        return pacienteRepository.findAllByAtivoTrue(paginacao).map(PacienteExportDto::new);
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody PacienteUpdateDto dados){
        Paciente paciente = pacienteRepository.getReferenceById(dados.id());
        paciente.atualizar(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void deletar(@PathVariable Long id){
        Paciente paciente = pacienteRepository.getReferenceById(id);
        paciente.deletar();
    }
}
