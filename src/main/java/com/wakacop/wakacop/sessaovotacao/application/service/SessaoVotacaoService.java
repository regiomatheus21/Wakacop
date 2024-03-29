package com.wakacop.wakacop.sessaovotacao.application.service;

import com.wakacop.wakacop.sessaovotacao.application.api.SessaoAberturaRequest;
import com.wakacop.wakacop.sessaovotacao.application.api.SessaoAberturaResponse;
import com.wakacop.wakacop.sessaovotacao.application.api.VotoRequest;
import com.wakacop.wakacop.sessaovotacao.application.api.VotoResponse;

import java.util.UUID;

public interface SessaoVotacaoService {
    SessaoAberturaResponse abreSessao(SessaoAberturaRequest sessaoAberturaRequest);

    VotoResponse recebeVoto(UUID idSessao, VotoRequest novoVoto);
}
