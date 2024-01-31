package com.wakacop.wakacop.sessaovotacao.application.service;

import com.wakacop.wakacop.Pauta.domain.Pauta;
import com.wakacop.wakacop.application.service.PautaService;
import com.wakacop.wakacop.sessaovotacao.application.api.SessaoAberturaRequest;
import com.wakacop.wakacop.sessaovotacao.application.api.SessaoAberturaResponse;
import com.wakacop.wakacop.sessaovotacao.domain.SessaoVotacao;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
public class SessaoVotacaoApplicationService implements SessaoVotacaoService{
    private final SessaoVotacaoRepository sessaoVotacaoRepository;
    private final PautaService pautaService;
    @Override
    public SessaoAberturaResponse abreSessao(SessaoAberturaRequest sessaoAberturaRequest) {
        log.info("[start] SessaoVotacaoApplicationService - abreSessao");
        Pauta pauta = pautaService.getPautaPorId(sessaoAberturaRequest.getIdPauta());
        SessaoVotacao sessaoVotacao = sessaoVotacaoRepository.salva(new SessaoVotacao(sessaoAberturaRequest, pauta));
        log.info("[finish] SessaoVotacaoApplicationService - abreSessao");
        return new SessaoAberturaResponse(sessaoVotacao);
    }
}
