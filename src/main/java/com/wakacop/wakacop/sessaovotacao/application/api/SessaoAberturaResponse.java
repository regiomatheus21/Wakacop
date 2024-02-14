package com.wakacop.wakacop.sessaovotacao.application.api;

import com.wakacop.wakacop.sessaovotacao.domain.SessaoVotacao;
import lombok.Getter;
import lombok.ToString;

import java.util.UUID;

@Getter
@ToString
public class SessaoAberturaResponse {
    private UUID idSessao;

    public SessaoAberturaResponse(SessaoVotacao sessaoVotacao){
        this.idSessao = sessaoVotacao.getId();
    }
}
