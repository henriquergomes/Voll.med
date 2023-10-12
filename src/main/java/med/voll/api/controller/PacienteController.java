package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.IRepository.IPacienteRepository;
import med.voll.api.Models.Paciente;
import med.voll.api.Records.DadosCadastroPaciente;
import med.voll.api.Records.GetListDadosPaciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/paciente")
public class PacienteController {

    @Autowired
    IPacienteRepository pacienteRepository;

    @PostMapping
    @Transactional
    public void SavePaciente(@RequestBody @Valid DadosCadastroPaciente dadosPaciente) {
        pacienteRepository.save(new Paciente(dadosPaciente));
    }

    @GetMapping
    public List<GetListDadosPaciente> GetAllPacientes() {
        return pacienteRepository.findAll().stream().map(GetListDadosPaciente::new).toList();
    }

    @GetMapping("/{id}")
    public List<GetListDadosPaciente> GetPacientesById(@PathVariable Long id) {
        return pacienteRepository.findById(id).stream().map(GetListDadosPaciente::new).toList();
    }

}
