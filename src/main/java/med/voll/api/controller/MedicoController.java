package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.IRepository.IMedicoRepository;
import med.voll.api.Models.Medico;
import med.voll.api.Records.DadosCadastroMedicos;
import med.voll.api.Records.DadosUpdateMedico;
import med.voll.api.Records.GetListDadosMedicos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/medico")
public class MedicoController {

    @Autowired
    private IMedicoRepository medicoRepository;

    @PostMapping
    @Transactional
    public void SaveMedico(@RequestBody @Valid DadosCadastroMedicos dados) {

        medicoRepository.save(new Medico(dados));
    }

    @GetMapping("/getAllMedicos")
    public Page<GetListDadosMedicos> GetAllMedicos(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
        return medicoRepository.findAll(paginacao).map(GetListDadosMedicos::new);
    }

    @GetMapping
    public Page<GetListDadosMedicos> GetAllMedicosAtivos(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
        return medicoRepository.findAllByAtivoTrue(paginacao).map(GetListDadosMedicos::new);
    }

    @GetMapping("/{id}")
    public List<GetListDadosMedicos> GetMedicosById(@PathVariable Long id) {
        return medicoRepository.findById(id).stream().map(GetListDadosMedicos::new).toList();
    }

    @PutMapping
    @Transactional
    public void UpdateMedico(@RequestBody @Valid DadosUpdateMedico dados) {
        var medico = medicoRepository.getReferenceById(dados.id());
        medico.UpdateMedico(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void DeleteMedico(@PathVariable Long id) {
        var medico = medicoRepository.getReferenceById(id);
        medico.Delete(id);
    }
}
