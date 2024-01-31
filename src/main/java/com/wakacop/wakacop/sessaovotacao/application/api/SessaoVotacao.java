package com.wakacop.wakacop.sessaovotacao.application.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sessao")
public interface SessaoVotacao {
    @PostMapping("/abertura")
    @ResponseStatus(HttpStatus.CREATED)
    SessaoAberturaResponse abreSessao(@RequestBody SessaoAberturaRequest sessaoAberturaRequest);

}
