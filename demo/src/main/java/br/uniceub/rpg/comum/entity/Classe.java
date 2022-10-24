package br.uniceub.rpg.comum.entity;

import lombok.*;

import javax.persistence.*;

@Table(name = "tb_classe")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Classe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_classe")
    private Long id;

    @Column(name = "no_classe")
    private String classe;

    @Column(name = "ds_classe")
    private String descricao;
}