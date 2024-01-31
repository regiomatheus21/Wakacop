package com.wakacop.wakacop.application.service;

import com.wakacop.wakacop.Pauta.domain.Pauta;

import java.util.UUID;

public interface PautaRepository {

    Pauta salva(Pauta pauta);

    Pauta buscaPautaPorId(UUID idPauta);
}
