package br.com.fiap.wear.repositories;

import br.com.fiap.wear.model.Usuario;
import jakarta.persistence.EntityManager;

public class UsuarioRepository {
    private EntityManager entityManager;

    public UsuarioRepository(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public Iterable<Usuario> findAllUsuario(){
        String jpql = "SELECT a FROM Usuario a";
        var query = entityManager.createQuery(jpql, Usuario.class);
        var u = query.getResultList();
        return u;
    }

    public Usuario findUsuarioById(Long usuarioId){
        Usuario u = entityManager.find(Usuario.class, usuarioId);
        if(u == null){
            return null;
        }
        return u;
    }

    public Iterable<Usuario> findUsuarioByGenero(String genero){
        String jpql = "SELECT a FROM Usuario a WHERE genero = :genero";
        var query = entityManager.createQuery(jpql, Usuario.class);
        query.setParameter("genero", genero);
        var p = query.getResultList();
        if(u == null){
            return null;
        }
        return u;
    }

    public void insertUsuario(Usuario usuario){
        try{
            entityManager.getTransaction().begin();
            entityManager.persist(usuario);
            entityManager.getTransaction().commit();
        }catch (Exception e){
            entityManager.getTransaction().rollback();
            throw e;
        }
    }

    public void updateUsuario(Usuario usuario){
        try{
            entityManager.getTransaction().begin();
            entityManager.merge(usuario);
            entityManager.getTransaction().commit();
        }catch (Exception e){
            entityManager.getTransaction().rollback();
            throw e;
        }
    }

    public void deleteUsuario(Long usuarioId){
        Usuario u = entityManager.find(Usuario.class, usuarioId);
        entityManager.getTransaction().begin();
        try{
            if(u != null){
                entityManager.remove(u);
            }
            entityManager.getTransaction().commit();
        }catch (Exception e){
            entityManager.getTransaction().rollback();
            throw e;
        }
    }
}
