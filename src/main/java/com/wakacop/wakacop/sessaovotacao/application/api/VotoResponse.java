package com.wakacop.wakacop.sessaovotacao.application.api;

import com.wakacop.wakacop.sessaovotacao.domain.VotoPauta;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@ToString
public class VotoResponse {
    private UUID id;
    private UUID idSessao;
    private LocalDateTime momentoVoto;
    private String cpfAssociado;

    public VotoResponse (VotoPauta voto){
        this.id = voto.getId();
        this.idSessao = voto.getIdSessao();
        this.cpfAssociado = voto.getCpfAssociado();
        this.momentoVoto = voto.getMomentoVoto();
    }
}
