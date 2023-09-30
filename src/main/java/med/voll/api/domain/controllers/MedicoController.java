package med.voll.api.domain.controllers;

import jakarta.validation.Valid;
import med.voll.api.domain.dtos.medico.DadosAtualizacaoMedico;
import med.voll.api.domain.dtos.medico.DadosListagemMedico;
import med.voll.api.domain.dtos.medico.DadosCadastroMedico;
import med.voll.api.domain.entities.Medico;
import med.voll.api.domain.repositories.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicos")
public class MedicoController {
    @Autowired
    private MedicoRepository repository;

    @PostMapping
    @Transactional
    @ResponseStatus(HttpStatus.CREATED)
    public Medico cadastrar(@RequestBody @Valid DadosCadastroMedico dados) {
        return repository.save(new Medico(dados));
    }
    @GetMapping
    public Page<DadosListagemMedico> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
        return repository.findAll(paginacao).map(DadosListagemMedico::new);
    }
    @PutMapping
    @Transactional
    public DadosAtualizacaoMedico atualizar(@RequestBody @Valid DadosAtualizacaoMedico dados){
        var medico = repository.getReferenceById(dados.id());
        return medico.atualizarInformacoes(dados);
    }
    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id){
        repository.deleteById(id);
    }

}
