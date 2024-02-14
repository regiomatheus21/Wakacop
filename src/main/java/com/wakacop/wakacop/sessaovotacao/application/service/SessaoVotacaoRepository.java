package com.wakacop.wakacop.sessaovotacao.application.service;

import com.wakacop.wakacop.sessaovotacao.domain.SessaoVotacao;

import java.util.List;
import java.util.UUID;

public interface SessaoVotacaoRepository {

    SessaoVotacao salva(SessaoVotacao sessaoVotacao);

    SessaoVotacao buscaPorId(UUID idSessao);

    List<SessaoVotacao> buscaAbertas();
}
