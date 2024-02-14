package com.wakacop.wakacop.sessaovotacao.application.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/sessao")
public interface SessaoVotacao {
    @PostMapping("/abertura")
    @ResponseStatus(HttpStatus.CREATED)
    SessaoAberturaResponse abreSessao(@RequestBody SessaoAberturaRequest sessaoAberturaRequest);
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/{idSessao}/voto")
    VotoResponse recebeVoto (@PathVariable UUID idSessao, @RequestBody VotoRequest novoVoto);
}
