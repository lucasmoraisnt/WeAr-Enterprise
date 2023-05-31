package br.com.fiap.wear.repositories;

import br.com.fiap.wear.model.Pessoa;
import jakarta.persistence.EntityManager;

public class PessoaRepository {
    private EntityManager entityManager;

    public PessoaRepository(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public Iterable<Pessoa> findAllPessoa(){
        String jpql = "SELECT a FROM Pessoa a";
        var query = entityManager.createQuery(jpql, Pessoa.class);
        var p = query.getResultList();
        return p;
    }

    public Pessoa findPessoaById(int id){
        Pessoa p = entityManager.find(Pessoa.class, id);
        if(p == null){
            return null;
        }
        return p;
    }

    public Iterable<Pessoa> findPessoaByType(String pessoa_type){
        String jpql = "SELECT a FROM Pessoa a WHERE pessoa_type = :pessoa_type";
        var query = entityManager.createQuery(jpql, Pessoa.class);
        query.setParameter("pessoa_type", pessoa_type);
        var p = query.getResultList();
        if(p == null){
            return null;
        }
        return p;
    }

    public void insertPessoa(Pessoa p){
        try{
            entityManager.getTransaction().begin();
            entityManager.persist(p);
            entityManager.getTransaction().commit();
        }catch (Exception e){
            entityManager.getTransaction().rollback();
            throw e;
        }
    }

    public void updatePessoa(Pessoa p){
        try{
            entityManager.getTransaction().begin();
            entityManager.merge(p);
            entityManager.getTransaction().commit();
        }catch (Exception e){
            entityManager.getTransaction().rollback();
            throw e;
        }
    }

    public void deletePessoa(int id){
        Pessoa p = entityManager.find(Pessoa.class, id);
        entityManager.getTransaction().begin();
        try{
            if(p != null){
                entityManager.remove(p);
            }
            entityManager.getTransaction().commit();
        }catch (Exception e){
            entityManager.getTransaction().rollback();
            throw e;
        }
    }
}
