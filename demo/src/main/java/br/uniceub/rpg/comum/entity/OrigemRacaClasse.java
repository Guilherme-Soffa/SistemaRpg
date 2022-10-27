package br.uniceub.rpg.comum.entity;


import lombok.*;

import javax.persistence.*;
@Table(name = "rl_origem_raca_classe")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class OrigemRacaClasse {

    @Id
    @Column(name = "fk_origem")
    private Long idOrigem;

    @Column(name = "fk_raca")
    private Long idRaca;

    @Column(name = "fk_classe")
    private Long idClasse;

    @ManyToOne
    @JoinColumn(name = "fk_origem", insertable = false, updatable = false)
    private Antecedente antecedente;

    @ManyToOne
    @JoinColumn(name = "fk_raca", insertable = false, updatable = false)
    private Raca raca;

    @ManyToOne
    @JoinColumn(name = "fk_classe", insertable = false, updatable = false)
    private Classe classe;
}
