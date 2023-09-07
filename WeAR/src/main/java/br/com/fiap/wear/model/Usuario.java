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
public class Usuario {
    @Id
    @GeneratedValue(strategy =  GenerationType.SEQUENCE)

    @Column(name = "usuarioId", nullable = false)
    private Long usuarioId;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "email", nullable = false)
    private String email;
    
    @Column(name = "senha", nullable = false)
    private String senha;

    @Column(name = "dataNascimento")
    private Date dataNascimento;

    @Column(name = "endereco")
    private String endereco;
    
    @Column(name = "telefone")
    private String telefone;
    
    @Column(name = "genero")
    private String genero;
}
