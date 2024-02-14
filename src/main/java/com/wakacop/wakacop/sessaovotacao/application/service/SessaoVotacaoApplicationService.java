package com.wakacop.wakacop.sessaovotacao.application.service;

import com.wakacop.wakacop.Pauta.domain.Pauta;
import com.wakacop.wakacop.application.service.PautaService;
import com.wakacop.wakacop.associado.application.service.AssociadoService;
import com.wakacop.wakacop.sessaovotacao.application.api.SessaoAberturaRequest;
import com.wakacop.wakacop.sessaovotacao.application.api.SessaoAberturaResponse;
import com.wakacop.wakacop.sessaovotacao.application.api.VotoRequest;
import com.wakacop.wakacop.sessaovotacao.application.api.VotoResponse;
import com.wakacop.wakacop.sessaovotacao.domain.PublicadorResultadoSessao;
import com.wakacop.wakacop.sessaovotacao.domain.SessaoVotacao;
import com.wakacop.wakacop.sessaovotacao.domain.VotoPauta;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Log4j2
public class SessaoVotacaoApplicationService implements SessaoVotacaoService{
    private final SessaoVotacaoRepository sessaoVotacaoRepository;
    private final PautaService pautaService;
    private final AssociadoService associadoService;
    private final PublicadorResultadoSessao publicadorResultadoSessao;
    @Override
    public SessaoAberturaResponse abreSessao(SessaoAberturaRequest sessaoAberturaRequest) {
        log.info("[start] SessaoVotacaoApplicationService - abreSessao");
        Pauta pauta = pautaService.getPautaPorId(sessaoAberturaRequest.getIdPauta());
        SessaoVotacao sessaoVotacao = sessaoVotacaoRepository.salva(new SessaoVotacao(sessaoAberturaRequest, pauta));
        log.info("[finish] SessaoVotacaoApplicationService - abreSessao");
        return new SessaoAberturaResponse(sessaoVotacao);
    }

    @Override
    public VotoResponse recebeVoto(UUID idSessao, VotoRequest novoVoto) {
        log.info ("[start] SessaoVotacaoApplicationService - recebeVoto ");
        SessaoVotacao sessao = sessaoVotacaoRepository.buscaPorId(idSessao);
        VotoPauta voto = sessao.recebeVotos(novoVoto, associadoService, publicadorResultadoSessao);
        sessaoVotacaoRepository.salva(sessao);
        log.info ("[finish] SessaoVotacaoApplicationService - recebeVoto ");
        return new VotoResponse(voto);
    }
}
