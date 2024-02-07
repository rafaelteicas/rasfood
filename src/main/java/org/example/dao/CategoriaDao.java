package org.example.dao;

import org.example.entity.Categoria;

import javax.persistence.EntityManager;
import java.util.List;

public class CategoriaDao {
    private EntityManager entityManager;

    public CategoriaDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void cadastrar(final Categoria categoria) {
        this.entityManager.persist(categoria);
    }

    public Categoria consultar(final Integer id) {
        return this.entityManager.find(Categoria.class, id);
    }

    public List<Categoria> consultarTodos() {
        String jpql = "SELECT c FROM Categoria c";
        return this.entityManager.createQuery(jpql, Categoria.class).getResultList();
    }

    public void atualizar(final Categoria cardapio) {
        this.entityManager.merge(cardapio);
    }

    public void excluir(final Categoria cardapio) {
        this.entityManager.remove(cardapio);
    }
}
