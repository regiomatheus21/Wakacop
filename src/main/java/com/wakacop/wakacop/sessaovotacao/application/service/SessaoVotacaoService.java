package com.wakacop.wakacop.sessaovotacao.application.service;

import com.wakacop.wakacop.sessaovotacao.application.api.SessaoAberturaRequest;
import com.wakacop.wakacop.sessaovotacao.application.api.SessaoAberturaResponse;

public interface SessaoVotacaoService {
    SessaoAberturaResponse abreSessao(SessaoAberturaRequest sessaoAberturaRequest);
}
