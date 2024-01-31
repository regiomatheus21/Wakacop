package com.wakacop.wakacop.infra;

import com.wakacop.wakacop.Pauta.domain.Pauta;
import com.wakacop.wakacop.application.service.PautaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

import java.util.UUID;

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

    @Override
    public Pauta buscaPautaPorId(UUID idPauta) {
       log.info("[start] PautaInfraRepository - buscaPautaPorId");
       Pauta pautaPorId = pautaSpringDataJPARepository.findById(idPauta)
                       .orElseThrow(() -> new RuntimeException("Pauta Nao encontrada"));
       log.info("[start] PautaInfraRepository - buscaPautaPorId");
        return pautaPorId;
    }
}
