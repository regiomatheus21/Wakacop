package com.wakacop.wakacop.infra;

import com.wakacop.wakacop.Pauta.domain.Pauta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PautaSpringDataJPARepository extends JpaRepository<Pauta, UUID> {

}
