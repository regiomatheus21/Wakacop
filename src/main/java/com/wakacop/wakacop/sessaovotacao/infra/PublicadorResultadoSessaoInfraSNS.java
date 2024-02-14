package com.wakacop.wakacop.sessaovotacao.infra;

import com.wakacop.wakacop.config.AwsConfigProperties;
import com.wakacop.wakacop.sessaovotacao.application.api.ResultadoSessaoResponse;
import com.wakacop.wakacop.sessaovotacao.domain.PublicadorResultadoSessao;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.cloud.aws.messaging.core.NotificationMessagingTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Log4j2
public class PublicadorResultadoSessaoInfraSNS implements PublicadorResultadoSessao {
    private final NotificationMessagingTemplate publicadorResultadosSNS;
    private final AwsConfigProperties awsConfigProperties;
    @Override
    public void publica(ResultadoSessaoResponse resultadoSessaoResponse) {
        log.debug("[start] PublicadorResultadoSessaoInfraSNS - publica");
        publicadorResultadosSNS.sendNotification(awsConfigProperties.getResultadoSessaoTopic(), resultadoSessaoResponse, resultadoSessaoResponse.getIdPauta().toString());
        log.debug("[finish] PublicadorResultadoSessaoInfraSNS - publica");
    }
}
