package com.wakacop.wakacop.sessaovotacao.domain;

import com.wakacop.wakacop.Pauta.domain.Pauta;
import com.wakacop.wakacop.associado.application.service.AssociadoService;
import com.wakacop.wakacop.sessaovotacao.application.api.ResultadoSessaoResponse;
import com.wakacop.wakacop.sessaovotacao.application.api.SessaoAberturaRequest;
import com.wakacop.wakacop.sessaovotacao.application.api.VotoRequest;
import com.wakacop.wakacop.sessaovotacao.application.api.VotoResponse;
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
@NoArgsConstructor(access = AccessLevel.PRIVATE)
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
    public ResultadoSessaoResponse obtemResultado(PublicadorResultadoSessao publicadorResultadoSessao){
        atualizaStatus(publicadorResultadoSessao);
        return new ResultadoSessaoResponse(this);
    }
    private void atualizaStatus(PublicadorResultadoSessao publicadorResultadoSessao) {
        if (this.status.equals(StatusSessaoVotacao.ABERTA)){
            if (LocalDateTime.now().isAfter(this.momentoEncerramento)){
                fechaSessao(publicadorResultadoSessao);
            }
        }
    }
    private void fechaSessao(PublicadorResultadoSessao publicadorResultadoSessao) {
        this.status = StatusSessaoVotacao.FECHADA;
        publicadorResultadoSessao.publica(new ResultadoSessaoResponse(this));
    }

    public VotoPauta recebeVotos (VotoRequest votoRequest, AssociadoService associadoService, PublicadorResultadoSessao publicadorResultadoSessao){
        validaSessaoAberta(publicadorResultadoSessao);
        validaAssociado(votoRequest.getCpfAssociado(),associadoService);
        VotoPauta voto = new VotoPauta(this,votoRequest);
        votos.put(votoRequest.getCpfAssociado(),voto);
        return voto;
    }
    private void validaAssociado(String cpfAssociado, AssociadoService associadoService) {
        associadoService.validaAssociadoAptoVoto(cpfAssociado);
        validaVotoDuplicado(cpfAssociado);
    }

    private void validaVotoDuplicado(String cpfAssociado) {
        if(this.votos.containsKey(cpfAssociado)){
            throw new RuntimeException("Associado já Votou nessa sessão!");
        }
    }

    private void validaSessaoAberta(PublicadorResultadoSessao publicadorResultadoSessao) {
        atualizaStatus(publicadorResultadoSessao);
        if (this.status.equals(StatusSessaoVotacao.FECHADA)){
            throw new RuntimeException("Sessão está fechada!");
        }
    }
    public Long getTotalVotos() {
        return Long.valueOf(this.votos.size());
    }

    public Long getTotalSim() {
        return calculaVotosPorOpcao(OpcaoVoto.SIM);
    }

    public Long getTotalNao() {
        return calculaVotosPorOpcao(OpcaoVoto.NAO);
    }

    private Long calculaVotosPorOpcao(OpcaoVoto opcao) {
        return votos.values().stream()
                .filter(votos -> votos.opcaoIgual(opcao))
                .count();
    }
}
