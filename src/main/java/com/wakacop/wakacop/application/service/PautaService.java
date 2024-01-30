package com.wakacop.wakacop.application.service;

import com.wakacop.wakacop.application.api.NovaPautaRequest;
import com.wakacop.wakacop.application.api.PautaCadastradaResponse;
import org.springframework.stereotype.Service;


public interface PautaService {
    PautaCadastradaResponse cadastraPauta(NovaPautaRequest novaPauta);
}
