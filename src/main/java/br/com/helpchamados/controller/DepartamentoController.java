package br.com.helpchamados.controller;

import br.com.helpchamados.dto.departamento.DepartamentoRequest;
import br.com.helpchamados.dto.departamento.DepartamentoResponse;
import br.com.helpchamados.service.DepartamentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/departamentos")
@RequiredArgsConstructor
public class DepartamentoController {

    private final DepartamentoService service;

    @PostMapping
    public ResponseEntity<DepartamentoResponse> criar(@RequestBody DepartamentoRequest request){
        DepartamentoResponse response = service.criar(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<DepartamentoResponse>> listar(){
        return ResponseEntity.ok(service.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DepartamentoResponse> buscarId(@PathVariable UUID id){
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> desativar(@PathVariable UUID id){
        service.inativar(id);
        return ResponseEntity.noContent().build();
    }

}
