package me.dio.coding.votacao.bbb.api.controller;

import lombok.AllArgsConstructor;
import me.dio.coding.votacao.bbb.api.model.ParticipanteModel;
import me.dio.coding.votacao.bbb.api.repository.ParticipanteRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/participantes")
@AllArgsConstructor
public class ParticipanteController {

    private final ParticipanteRepository repository;

    @PostMapping("/salvar")
    public ResponseEntity<ParticipanteModel> save(@RequestBody ParticipanteModel participante) {
        ParticipanteModel entity = repository.save(participante);
        return ResponseEntity.ok(entity);
    }

    @GetMapping("/consulta")
    public ResponseEntity<ParticipanteModel> find(@RequestParam String id) {
        Optional<ParticipanteModel> optParticipante = repository.findById(id);
        if (optParticipante.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(optParticipante.get());
    }
}
