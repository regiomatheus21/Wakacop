package com.wakacop.wakacop.infra;

import com.wakacop.wakacop.Pauta.domain.Pauta;
import com.wakacop.wakacop.application.service.PautaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
@Log4j2
public class PautaInfraRepository implements PautaRepository {
        private final PautaSpringDataJPARepository pautaSpringDataJPARepository;
    @Override
    public Pauta salva(Pauta pauta) {
        log.info("[start] PautaInfraRepository - salva ");
        pautaSpringDataJPARepository.save(pauta);
        log.info("[start] PautaInfraRepository - salva ");
        return pauta;
    }
}
