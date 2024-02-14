package com.wakacop.wakacop.sessaovotacao.application.api;

import com.wakacop.wakacop.sessaovotacao.domain.OpcaoVoto;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class VotoRequest {
    private String cpfAssociado;
    private OpcaoVoto opcaoVoto;
}
