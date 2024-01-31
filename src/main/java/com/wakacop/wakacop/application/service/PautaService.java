package com.wakacop.wakacop.application.service;

import com.wakacop.wakacop.Pauta.domain.Pauta;
import com.wakacop.wakacop.application.api.NovaPautaRequest;
import com.wakacop.wakacop.application.api.PautaCadastradaResponse;
import org.springframework.stereotype.Service;

import java.util.UUID;


public interface PautaService {
    PautaCadastradaResponse cadastraPauta(NovaPautaRequest novaPauta);

    Pauta getPautaPorId(UUID idPauta);
}
