package com.wakacop.wakacop.sessaovotacao.domain;

import com.wakacop.wakacop.Pauta.domain.Pauta;
import com.wakacop.wakacop.sessaovotacao.application.api.SessaoAberturaRequest;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import javax.persistence.*;
@Getter
@ToString
@Entity
public class SessaoVotacao {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "uuid",updatable = false,unique = true,nullable = false)
    private UUID id;
    private UUID idPauta;
    private Integer tempoDuracao;

    @Enumerated(EnumType.STRING)
    private StatusSessaoVotacao status;
    private LocalDateTime momentoAbertura;
    private LocalDateTime momentoEncerramento;

    @OneToMany(mappedBy = "sessaoVotacao", cascade = CascadeType.ALL,orphanRemoval = true)
    @LazyCollection(LazyCollectionOption.FALSE)
    @MapKey(name = "cpfAssociado")
    private Map<String,VotoPauta> votos;

    public SessaoVotacao(SessaoAberturaRequest sessaoAberturaRequest, Pauta pauta) {
        this.idPauta = pauta.getId();
        this.tempoDuracao =sessaoAberturaRequest.getTempoDuracao().orElse(1);
        this.momentoAbertura = LocalDateTime.now();
        this.momentoEncerramento = momentoAbertura.plusMinutes(this.tempoDuracao);
        this.status = StatusSessaoVotacao.ABERTA;
        this.votos = new HashMap<>();
    }
}
