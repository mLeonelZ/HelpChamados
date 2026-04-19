package br.com.helpchamados.controller;

import br.com.helpchamados.dto.sla.SlaRequest;
import br.com.helpchamados.dto.sla.SlaResponse;
import br.com.helpchamados.service.SlaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/sla")
@RequiredArgsConstructor
public class SlaController {

    private final SlaService service;

    @PostMapping
    public ResponseEntity<SlaResponse> salvar(@RequestBody SlaRequest request){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(request));
    }

    @GetMapping
    public ResponseEntity<List<SlaResponse>> listar(){
        return ResponseEntity.ok(service.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SlaResponse> listarId(@PathVariable UUID id){
        return ResponseEntity.ok(service.listarId(id));
    }



}

