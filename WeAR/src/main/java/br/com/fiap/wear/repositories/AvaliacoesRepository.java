package br.com.fiap.wear.repositories;

import br.com.fiap.wear.model.Avaliacoes;
import jakarta.persistence.EntityManager;

public class AvaliacoesRepository {
    private EntityManager entityManager;

    public AvaliacoesRepository(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public Iterable<Avaliacoes> findAllAvaliacoes(){
        String jpql = "SELECT a FROM Avaliacoes a";
        var query = entityManager.createQuery(jpql, Avaliacoes.class);
        var a = query.getResultList();
        return a;
    }

    public Avaliacoes findAvaliacoesById(Long avaliacoesId){
        Avaliacoes a = entityManager.find(Avaliacoes.class, avaliacoesId);
        if(a == null){
            return null;
        }
        return a;
    }

    public Iterable<Avaliacoes> findAvaliacoesByUsuario(Long usuarioId){
        String jpql = "SELECT a FROM Avaliacoes a WHERE usuarioId = :usuarioId";
        var query = entityManager.createQuery(jpql, Avaliacoes.class);
        query.setParameter("usuarioId", usuarioId);
        var a = query.getResultList();
        if(a == null){
            return null;
        }
        return a;
    }

    public void insertAvaliacoes(Avaliacoes a){
        try{
            entityManager.getTransaction().begin();
            entityManager.persist(a);
            entityManager.getTransaction().commit();
        }catch (Exception e){
            entityManager.getTransaction().rollback();
            throw e;
        }
    }

    public void updateAvaliacoes(Avaliacoes a){
        try{
            entityManager.getTransaction().begin();
            entityManager.merge(a);
            entityManager.getTransaction().commit();
        }catch (Exception e){
            entityManager.getTransaction().rollback();
            throw e;
        }
    }

    public void deleteAvaliacoes(Long avaliacoesId){
        Avaliacoes a = entityManager.find(Avaliacoes.class, avaliacoesId);
        entityManager.getTransaction().begin();
        try{
            if(a != null){
                entityManager.remove(a);
            }
            entityManager.getTransaction().commit();
        }catch (Exception e){
            entityManager.getTransaction().rollback();
            throw e;
        }
    }
}
