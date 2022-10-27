package br.uniceub.rpg.comum.entity;

import lombok.*;

import javax.persistence.*;

@Table(name = "tb_origem")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Origem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_origem")
    private Long id;

    @Column(name = "no_origem")
    private String origem;

    @Column(name = "ds_origem")
    private String descricao;

}