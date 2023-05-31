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

    @Column(name = "id_medidas", nullable = false)
    private Long id;

    @Column(name = "nr_altura", nullable = false)
    private int altura;

    @Column(name = "nr_busto", nullable = false)
    private double busto;

    @Column(name = "nr_cintura", nullable = false)
    private double cintura;

    @Column(name = "nr_quadril", nullable = false)
    private double quadril;
}
