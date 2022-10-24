package br.uniceub.rpg.comum.entity;

import lombok.*;

import javax.persistence.*;

@Table(name = "tb_raca")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Raca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_raca")
    private Long id;

    @Column(name = "no_raca")
    private String raca;

    @Column(name = "ds_raca")
    private String descricao;

}