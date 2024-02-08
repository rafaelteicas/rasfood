package org.example.dao;


import org.example.entity.Ordem;

import javax.persistence.EntityManager;
import java.util.List;

public class OrdemDao {
    private EntityManager entityManager;

    public OrdemDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void cadastrar(final Ordem ordem) {
        this.entityManager.persist(ordem);
    }

    public Ordem consultar(final Integer id) {
        return this.entityManager.find(Ordem.class, id);
    }

    public List<Ordem> consultarTodos() {
        String jpql = "SELECT o FROM Ordem o";
        return this.entityManager.createQuery(jpql, Ordem.class).getResultList();
    }

    public void atualizar(final Ordem ordem) {
        this.entityManager.merge(ordem);
    }

    public void excluir(final Ordem ordem) {
        this.entityManager.remove(ordem);
    }
}
