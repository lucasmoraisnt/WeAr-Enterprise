package br.com.fiap.wear.model;

import br.com.fiap.wear.enums.Cores;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Produto {
    @Id
    @GeneratedValue(strategy =  GenerationType.SEQUENCE)

    @Column(name = "id_produto", nullable = false)
    private Long id;

    @Column(name = "nm_produto", nullable = false)
    private String nome;

    @Column(name = "nr_preco", nullable = false)
    private double preco;

    @Column(name = "ds_cor", nullable = false)
    private Cores cor;

    @Column(name = "nr_tam", nullable = false)
    private String tamanho;
}
