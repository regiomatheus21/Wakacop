package com.wakacop.wakacop.application.service;

import com.wakacop.wakacop.Pauta.domain.Pauta;
import com.wakacop.wakacop.application.api.NovaPautaRequest;
import com.wakacop.wakacop.application.api.PautaCadastradaResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Log4j2
public class PautaApplicationService implements PautaService{
    private final PautaRepository pautaRepository;
    @Override
    public PautaCadastradaResponse cadastraPauta(NovaPautaRequest novaPauta) {
       log.info("[start] PautaApplicationService - cadastraPauta");
       log.info("[Nova Pauta] {}",novaPauta);
        Pauta pauta = pautaRepository.salva(new Pauta(novaPauta));
       log.info("[start] PautaApplicationService - cadastraPauta");
        return new PautaCadastradaResponse(pauta);
    }

    @Override
    public Pauta getPautaPorId(UUID idPauta) {
        log.info("[start] PautaApplicationService - getPautaPorId");
        Pauta pautaPorId = pautaRepository.buscaPautaPorId(idPauta);
        log.info("[finish] PautaApplicationService - getPautaPorId");
        return pautaPorId;
    }

}
