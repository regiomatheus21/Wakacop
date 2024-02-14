package com.wakacop.wakacop.sessaovotacao.application.service;

import com.wakacop.wakacop.sessaovotacao.domain.SessaoVotacao;

import java.util.UUID;

public interface SessaoVotacaoRepository {

    SessaoVotacao salva(SessaoVotacao sessaoVotacao);

    SessaoVotacao buscaPorId(UUID idSessao);
}
