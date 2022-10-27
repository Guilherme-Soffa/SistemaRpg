package br.uniceub.rpg.comum.entity;

import lombok.*;

import javax.persistence.*;
@Table(name = "rl_antecedente_raca_classe")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class AntecedenteRacaClasse {
    @Id
    @Column(name = "fk_antecedente")
    private Long idAntecedente;

    @Column(name = "fk_raca")
    private Long idRaca;

    @Column(name = "fk_classe")
    private Long idClasse;

    @ManyToOne
    @JoinColumn(name = "fk_antecedente", insertable = false, updatable = false)
    private Antecedente antecedente;

    @ManyToOne
    @JoinColumn(name = "fk_raca", insertable = false, updatable = false)
    private Raca raca;

    @ManyToOne
    @JoinColumn(name = "fk_classe", insertable = false, updatable = false)
    private Classe classe;
}
