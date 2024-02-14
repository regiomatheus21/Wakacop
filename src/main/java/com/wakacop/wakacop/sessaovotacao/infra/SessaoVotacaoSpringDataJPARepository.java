package com.wakacop.wakacop.sessaovotacao.infra;

import com.wakacop.wakacop.sessaovotacao.domain.SessaoVotacao;
import com.wakacop.wakacop.sessaovotacao.domain.StatusSessaoVotacao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface SessaoVotacaoSpringDataJPARepository extends JpaRepository<SessaoVotacao, UUID> {
    List<SessaoVotacao> findByStatus(StatusSessaoVotacao statusSessaoVotacao);
}
