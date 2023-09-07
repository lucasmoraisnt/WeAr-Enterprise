package br.com.fiap.wear.repositories;

import br.com.fiap.wear.model.PecasVestuario;
import jakarta.persistence.EntityManager;

public class PecasVestuarioRepository {
    private EntityManager entityManager;

    public PecasVestuarioRepository(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public Iterable<PecasVestuario> findAllPecasVestuario(){
        String jpql = "SELECT a FROM PecasVestuario a";
        var query = entityManager.createQuery(jpql, PecasVestuario.class);
        var p = query.getResultList();
        return p;
    }

    public PecasVestuario findPecaVestuarioById(Long pecasVestuarioId){
        PecasVestuario p = entityManager.find(PecasVestuario.class, pecasVestuarioId);
        if(p == null){
            return null;
        }
        return p;
    }

    public Iterable<PecasVestuario> findPecasVestuarioByMarca(String marca){
        String jpql = "SELECT a FROM PecasVestuario a WHERE marca = :marca";
        var query = entityManager.createQuery(jpql, PecasVestuario.class);
        query.setParameter("marca", marca);
        var p = query.getResultList();
        if(p == null){
            return null;
        }
        return p;
    }

    public void insertPecasVestuario(PecasVestuario p){
        try{
            entityManager.getTransaction().begin();
            entityManager.persist(p);
            entityManager.getTransaction().commit();
        }catch (Exception e){
            entityManager.getTransaction().rollback();
            throw e;
        }
    }

    public void updatePecasVestuario(PecasVestuario p){
        try{
            entityManager.getTransaction().begin();
            entityManager.merge(p);
            entityManager.getTransaction().commit();
        }catch (Exception e){
            entityManager.getTransaction().rollback();
            throw e;
        }
    }

    public void deletePecasVestuario(Long pecasVestuarioId){
        PecasVestuario p = entityManager.find(PecasVestuario.class, pecasVestuarioId);
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
