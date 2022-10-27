package br.uniceub.rpg.comum.entity;

import lombok.*;

import javax.persistence.*;

@Table(name = "tb_antecedente")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Antecedente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_antecedente")
    private Long id;

    @Column(name = "no_antecedente")
    private String antecedente;

    @Column(name = "ds_antecedente")
    private String descricao;

}