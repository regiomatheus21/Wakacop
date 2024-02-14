package com.wakacop.wakacop.sessaovotacao.infra;

import com.wakacop.wakacop.sessaovotacao.application.service.SessaoVotacaoRepository;
import com.wakacop.wakacop.sessaovotacao.domain.SessaoVotacao;
import com.wakacop.wakacop.sessaovotacao.domain.StatusSessaoVotacao;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
@RequiredArgsConstructor
@Log4j2
public class SessaoVotacaoInfraRepository implements SessaoVotacaoRepository {
    private final SessaoVotacaoSpringDataJPARepository sessaoVotacaoSpringDataJPARepository;
    @Override
    public SessaoVotacao salva(SessaoVotacao sessaoVotacao) {
        log.info("[start] SessaoVotacaoInfraRepository - salva");
        sessaoVotacaoSpringDataJPARepository.save(sessaoVotacao);
        log.info("[finish] SessaoVotacaoInfraRepository - salva");
        return sessaoVotacao;
    }

    @Override
    public SessaoVotacao buscaPorId(UUID idSessao) {
        log.info("[start] SessaoVotacaoInfraRepository - buscaPorId ");
        SessaoVotacao sessao= sessaoVotacaoSpringDataJPARepository.findById(idSessao)
                .orElseThrow(() -> new RuntimeException("Sessão não encontrada!") );
        log.info("[finish] SessaoVotacaoInfraRepository - buscaPorId ");
        return sessao;
    }

    @Override
    public List<SessaoVotacao> buscaAbertas() {
        log.debug("[start] SessaoVotacaoInfraRepository - buscaAbertas");
        List<SessaoVotacao> sessoes = sessaoVotacaoSpringDataJPARepository.findByStatus(StatusSessaoVotacao.ABERTA);
        log.debug("[finish] SessaoVotacaoInfraRepository - buscaAbertas");
        return sessoes;
    }
}
