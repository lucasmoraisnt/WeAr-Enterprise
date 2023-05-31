package br.com.fiap.wear.repositories;

import br.com.fiap.wear.model.Produto;
import jakarta.persistence.EntityManager;

public class ProdutoRepository {
    private EntityManager entityManager;

    public ProdutoRepository(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public Iterable<Produto> findAllProduto(){
        String jpql = "SELECT a FROM Produto a";
        var query = entityManager.createQuery(jpql, Produto.class);
        var p = query.getResultList();
        return p;
    }

    public Produto findProdutoById(int id){
        Produto p = entityManager.find(Produto.class, id);
        if(p == null){
            return null;
        }
        return p;
    }

    public Iterable<Produto> findProdutoByType(String produto_type){
        String jpql = "SELECT a FROM Produto a WHERE produto_type = :produto_type";
        var query = entityManager.createQuery(jpql, Produto.class);
        query.setParameter("produto_type", produto_type);
        var p = query.getResultList();
        if(p == null){
            return null;
        }
        return p;
    }

    public void insertProduto(Produto p){
        try{
            entityManager.getTransaction().begin();
            entityManager.persist(p);
            entityManager.getTransaction().commit();
        }catch (Exception e){
            entityManager.getTransaction().rollback();
            throw e;
        }
    }

    public void updateProduto(Produto p){
        try{
            entityManager.getTransaction().begin();
            entityManager.merge(p);
            entityManager.getTransaction().commit();
        }catch (Exception e){
            entityManager.getTransaction().rollback();
            throw e;
        }
    }

    public void deleteProduto(int id){
        Produto p = entityManager.find(Produto.class, id);
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
