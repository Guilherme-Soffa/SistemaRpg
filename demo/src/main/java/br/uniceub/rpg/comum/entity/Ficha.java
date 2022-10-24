package br.uniceub.rpg.comum.entity;

import lombok.*;

import javax.persistence.*;

@Table(name = "tb_ficha")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Ficha {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_ficha")
    private Long id;

    @Column(name = "fk_usuario")
    private String usuario;

    @Column(name = "fk_raca")
    private String raca;

    @Column(name = "fk_classe")
    private String classe;

    @Column(name = "fk_antecedente")
    private String antecedente;

    @Column(name = "fk_origem")
    private String origem;

}