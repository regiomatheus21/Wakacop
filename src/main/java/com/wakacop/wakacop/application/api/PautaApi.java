package com.wakacop.wakacop.application.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/pauta")
public interface PautaApi {
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    PautaCadastradaResponse cadastraPauta (@RequestBody NovaPautaRequest novaPauta);
}
