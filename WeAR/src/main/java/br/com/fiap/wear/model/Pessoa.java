package br.com.fiap.wear.model;

import java.sql.Date;
import java.util.List;

import br.com.fiap.wear.enums.Genero;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Pessoa {
    @Id
    @GeneratedValue(strategy =  GenerationType.SEQUENCE)

    @Column(name = "id_pessoa", nullable = false)
    private Long id;

    @Column(name = "nm_pessoa", nullable = false)
    private String nome;

    @Column(name = "nr_rg")
    private double rg;

    @Column(name = "dt_nasc")
    private Date dtNasc;

    @Column(name = "fl_sx_gen")
    private Genero genero;

    public Pessoa(String nome) {
        this.nome = nome;
    }
}
