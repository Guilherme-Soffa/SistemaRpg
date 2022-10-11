package comum.entity;

import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.time.LocalDate;

@Table(name = "tb_usuario")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Usuario {

    @Id
    @Column(name = "pk_usuario")
    private Long id;

    @Column(name = "no_usuario")
    private String usuario;

    @Column(name = "password")
    private String senha;

}