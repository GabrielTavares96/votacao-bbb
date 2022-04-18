package me.dio.coding.votacao.bbb.api.controller;

import me.dio.coding.votacao.bbb.api.model.ParameterModel;
import me.dio.coding.votacao.bbb.api.repository.ParameterRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/parameters")
public class ParameterController {

    private final ParameterRepository repository;

    public ParameterController(ParameterRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/salvar")
    public ResponseEntity<ParameterModel> save(@RequestBody ParameterModel parameter){
        ParameterModel entity = repository.save(parameter);
        return ResponseEntity.ok(entity);
    }

    @GetMapping("/consulta")
    public ResponseEntity<ParameterModel> find(@RequestParam String chave){
        Optional<ParameterModel> optParameter = repository.findById(chave);
        if(optParameter.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        
        return ResponseEntity.ok(optParameter.get());
    }
}
