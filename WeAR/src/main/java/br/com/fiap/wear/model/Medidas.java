package br.com.fiap.wear.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Medidas {
    @Id
    @GeneratedValue(strategy =  GenerationType.SEQUENCE)

    @Column(name = "medidasId", nullable = false)
    private Long medidasId;

    @Column(name = "altura", nullable = false)
    private double altura;

    @Column(name = "busto", nullable = false)
    private double busto;

    @Column(name = "cintura", nullable = false)
    private double cintura;

    @Column(name = "quadril", nullable = false)
    private double quadril;

    @Column(name = "ombro", nullable = false)
    private double ombro;

    @Column(name = "comprimentoBraco", nullable = false)
    private double comprimentoBraco;

    @Column(name = "comprimentoPerna", nullable = false)
    private double comprimentoPerna;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "usuarioId")
    private Usuario usuario;
}
