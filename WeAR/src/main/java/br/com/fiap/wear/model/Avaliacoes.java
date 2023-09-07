package br.com.fiap.wear.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Avaliacoes {
    @Id
    @GeneratedValue(strategy =  GenerationType.SEQUENCE)

    @Column(name = "avaliacoesId", nullable = false)
    private Long avaliacoesId;

    @Column(name = "nota", nullable = false)
    private int nota;

    @Column(name = "comentario")
    private String comentario;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "usuarioId")
    private Usuario usuario;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pecasVestuarioId")
    private PecasVestuario pecasVestuario;

}
