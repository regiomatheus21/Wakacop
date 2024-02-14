package com.wakacop.wakacop.sessaovotacao.domain;

import com.wakacop.wakacop.sessaovotacao.application.api.VotoRequest;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@ToString
@Entity
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class VotoPauta {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "uuid",updatable = false,unique = true,nullable = false)
    private UUID id;
    @ManyToOne
    @JoinColumn(name = "sessao_votacao_id")
    private SessaoVotacao sessaoVotacao;
    private String cpfAssociado;
    private OpcaoVoto opcaoVoto;
    private LocalDateTime momentoVoto;

    public VotoPauta (SessaoVotacao sessaoVotacao, VotoRequest votoRequest){
        this.sessaoVotacao = sessaoVotacao;
        this.cpfAssociado = votoRequest.getCpfAssociado();
        this.opcaoVoto = votoRequest.getOpcaoVoto();
        this.momentoVoto = LocalDateTime.now();
    }

    public UUID getIdSessao(){return this.sessaoVotacao.getId();}

    public boolean opcaoIgual(OpcaoVoto opcao) {
        return this.opcaoVoto.equals(opcao);
    }
}
