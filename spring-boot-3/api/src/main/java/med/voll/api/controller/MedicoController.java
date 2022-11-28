package med.voll.api.controller;


import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.controller.dto.MedicoDto;
import med.voll.api.controller.dto.MedicoExportDto;
import med.voll.api.model.Medico;
import med.voll.api.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository medicoRepository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid MedicoDto dados){
        medicoRepository.save(new Medico(dados));
    }

    @GetMapping
    public Page<MedicoExportDto> listar(@PageableDefault(size = 10, sort = "nome") Pageable paginacao){
        return medicoRepository.findAll(paginacao).map(MedicoExportDto::new);
    }
}
