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
    private Long idUsuario;

    @Column(name = "fk_raca")
    private Long idRaca;

    @Column(name = "fk_classe")
    private Long idClasse;

    @Column(name = "fk_antecedente")
    private Long idAntecedente;

    @Column(name = "fk_origem")
    private Long idOrigem;

    @ManyToOne
    @JoinColumn(name = "fk_usuario", insertable = false, updatable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "fk_raca", insertable = false, updatable = false)
    private Raca raca;

    @ManyToOne
    @JoinColumn(name = "fk_classe", insertable = false, updatable = false)
    private Classe classe;

    @ManyToOne
    @JoinColumn(name = "fk_antecedente", insertable = false, updatable = false)
    private Antecedente antecedente;

    @ManyToOne
    @JoinColumn(name = "fk_origem", insertable = false, updatable = false)
    private Origem origem;

}