package com.wakacop.wakacop.sessaovotacao.application.api;

import com.wakacop.wakacop.sessaovotacao.domain.SessaoVotacao;
import com.wakacop.wakacop.sessaovotacao.domain.StatusSessaoVotacao;
import lombok.Getter;
import lombok.ToString;
import net.bytebuddy.asm.Advice;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@ToString
public class ResultadoSessaoResponse {
    private UUID idSessao;
    private UUID idPauta;
    private StatusSessaoVotacao status;
    private LocalDateTime momentoAbertura;
    private LocalDateTime momentoEncerramento;
    private Long totalVotos;
    private Long totalSim;
    private Long totalNao;

    public ResultadoSessaoResponse (SessaoVotacao sessao){
        this.idSessao = sessao.getId();
        this.idPauta = sessao.getIdPauta();
        this.status = sessao.getStatus();
        this.momentoAbertura = sessao.getMomentoAbertura();
        this.totalVotos = sessao.getTotalVotos();
        this.totalSim = sessao.getTotalSim();
        this.totalNao = sessao.getTotalNao();
    }

}
