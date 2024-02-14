package com.wakacop.wakacop.associado.application.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
public class AssociadoApplicationService {
    private final SerproClientFeign serproClientFeign;

    public void validaAssociadoAptoVoto(String cpfAssociado){
        log.info("[start] AssociadoApplicationService - validaAssociadoAptoVoto ");
        ConsultaCPFResponse consultaCPFResponse = serproClientFeign.consultaCPF(TOKEN , cpfAssociado);
        valida(consultaCPFResponse);
        log.info("[finish] AssociadoApplicationService - validaAssociadoAptoVoto ");
    }

    private void valida(ConsultaCPFResponse consultaCPFResponse) {
        if (consultaCPFResponse.isInvalid()){
            throw new RuntimeException("CPF associado invalido");
        }
    }
    private static final String TOKEN = "Bearer 06aef429-a981-3ec5-a1f8-71d38d86481e ";
}
