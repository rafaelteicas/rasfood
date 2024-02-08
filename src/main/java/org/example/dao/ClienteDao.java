package org.example.dao;


import org.example.entity.Cliente;

import javax.persistence.EntityManager;
import java.util.List;

public class ClienteDao {
    private EntityManager entityManager;

    public ClienteDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void cadastrar(final Cliente cliente) {
        this.entityManager.persist(cliente);
    }

    public Cliente consultar(final Integer id) {
        return this.entityManager.find(Cliente.class, id);
    }

    public List<Cliente> consultarTodos() {
        String jpql = "SELECT c FROM Cliente c";
        return this.entityManager.createQuery(jpql, Cliente.class).getResultList();
    }

    public void atualizar(final Cliente cliente) {
        this.entityManager.merge(cliente);
    }

    public void excluir(final Cliente cliente) {
        this.entityManager.remove(cliente);
    }
}