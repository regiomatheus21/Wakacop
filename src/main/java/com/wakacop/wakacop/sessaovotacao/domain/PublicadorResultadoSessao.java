package com.wakacop.wakacop.sessaovotacao.domain;

import com.wakacop.wakacop.sessaovotacao.application.api.ResultadoSessaoResponse;

public interface PublicadorResultadoSessao {
    void publica(ResultadoSessaoResponse resultadoSessaoResponse);
}
