package br.com.fiap.wear.repositories;

import br.com.fiap.wear.model.Medidas;
import jakarta.persistence.EntityManager;

public class MedidasRepository {
    private EntityManager entityManager;

    public MedidasRepository(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public Iterable<Medidas> findAllMedidas(){
        String jpql = "SELECT a FROM Medidas a";
        var query = entityManager.createQuery(jpql, Medidas.class);
        var medidas = query.getResultList();
        return medidas;
    }

    public Medidas findMedidasById(Long medidasId){
        Medidas medidas = entityManager.find(Medidas.class, medidasId);
        if(medidas == null){
            return null;
        }
        return medidas;
    }

    public Iterable<Medidas> findMedidasByType(String medidas_type){
        String jpql = "SELECT a FROM Medidas a WHERE medidas_type = :medidas_type";
        var query = entityManager.createQuery(jpql, Medidas.class);
        query.setParameter("medidas_type", medidas_type);
        var medidas = query.getResultList();
        if(medidas == null){
            return null;
        }
        return medidas;
    }

    public void insertMedidas(Medidas medidas){
        try{
            entityManager.getTransaction().begin();
            entityManager.persist(medidas);
            entityManager.getTransaction().commit();
        }catch (Exception e){
            entityManager.getTransaction().rollback();
            throw e;
        }
    }

    public void updateMedidas(Medidas medidas){
        try{
            entityManager.getTransaction().begin();
            entityManager.merge(medidas);
            entityManager.getTransaction().commit();
        }catch (Exception e){
            entityManager.getTransaction().rollback();
            throw e;
        }
    }

    public void deleteMedidas(Long medidasId){
        Medidas medidas = entityManager.find(Medidas.class, id);
        entityManager.getTransaction().begin();
        try{
            if(medidas != null){
                entityManager.remove(medidas);
            }
            entityManager.getTransaction().commit();
        }catch (Exception e){
            entityManager.getTransaction().rollback();
            throw e;
        }
    }
}
