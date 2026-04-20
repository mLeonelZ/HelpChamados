package br.com.helpchamados.controller;

import br.com.helpchamados.dto.chamado.ChamadoRequest;
import br.com.helpchamados.dto.chamado.ChamadoResponse;
import br.com.helpchamados.service.ChamadoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/chamados")
@RequiredArgsConstructor
public class ChamadoController {

    private final ChamadoService service;

    @PostMapping
    public ResponseEntity<ChamadoResponse> criar(@RequestBody ChamadoRequest request){
        ChamadoResponse response = service.criar(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

}
