package com.wakacop.wakacop.application.api;

import com.wakacop.wakacop.Pauta.domain.Pauta;
import com.wakacop.wakacop.application.service.PautaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Log4j2
public class PautaController implements PautaApi {
    private final PautaService pautaService;
    @Override
    public PautaCadastradaResponse cadastraPauta(NovaPautaRequest novaPauta) {
        log.info("[start] PautaController cadastraPauta");
        PautaCadastradaResponse pautaCadastrada = pautaService.cadastraPauta(novaPauta);
        log.info("[start] PautaController cadastraPauta");
        return pautaCadastrada;
    }
}
