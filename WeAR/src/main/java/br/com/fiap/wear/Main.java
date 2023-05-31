package br.com.fiap.wear;

import br.com.fiap.wear.model.Pessoa;
import br.com.fiap.wear.repositories.PessoaRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.UUID;
public class Main {
    public static void main(String[] args) {
        try{
            EntityManagerFactory entityManagerFactory = Persistence.
                    createEntityManagerFactory("my-persistence-unit");
            EntityManager entityManager = entityManagerFactory.createEntityManager();

            var pr = new PessoaRepository(entityManager);

            var novoCliente = new Pessoa("Lucas");
            pr.insertPessoa(novoCliente);

            entityManager.close();
            entityManagerFactory.close();
        }catch(Exception e){
            throw e;
        }
    }
}
