package br.com.fiap.wear.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class PecasVestuario {
    @Id
    @GeneratedValue(strategy =  GenerationType.SEQUENCE)

    @Column(name = "pecasVestuarioId", nullable = false)
    private Long pecasVestuarioId;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "categoria", nullable = false)
    private String categoria;

    @Column(name = "marca", nullable = false)
    private String marca;

    @Column(name = "tamanho", nullable = false)
    private String tamanho;

    @Column(name = "cor", nullable = false)
    private String cor;

    @Column(name = "material", nullable = false)
    private String material;

    @Column(name = "imagem", nullable = false)
    private String imagem;

    @Column(name = "preco", nullable = false)
    private double preco;

    @Column(name = "dataCadastro", nullable = false)
    private Date dataCadastro;
}
