package br.com.helpchamados.controller;

import br.com.helpchamados.dto.categoria.CategoriaRequest;
import br.com.helpchamados.dto.categoria.CategoriaResponse;
import br.com.helpchamados.service.CategoriaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
@RequiredArgsConstructor
public class CategoriaController {

    private final CategoriaService service;

    @PostMapping
    public ResponseEntity<CategoriaResponse> criar(@RequestBody CategoriaRequest request){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(request));
    }

    @GetMapping
    public ResponseEntity<List<CategoriaResponse>> listar(){
        return ResponseEntity.ok(service.listar());
    }

}
