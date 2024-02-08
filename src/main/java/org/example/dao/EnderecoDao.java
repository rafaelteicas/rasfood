package org.example.dao;

import org.example.entity.Endereco;

import javax.persistence.EntityManager;
import java.util.List;

public class EnderecoDao {
    private EntityManager entityManager;

    public EnderecoDao (EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void cadastrar(Endereco endereco) {
        this.entityManager.persist(endereco);
    }

    public Endereco consultar(Integer id) {
        return this.entityManager.find(Endereco.class, id);
    }

    public List<Endereco> consultarTodos() {
        String jpql = "SELECT e FROM Endereco e";
        return this.entityManager.createQuery(jpql, Endereco.class).getResultList();
    }

    public Endereco consultarPorId(final Integer id) {
        String jpql = "SELECT e FROM Endereco e WHERE id = :id";
        return this.entityManager.createQuery(jpql, Endereco.class).setParameter("id", id).getSingleResult();
    }

    public void atualizar(final Endereco endereco) {
        this.entityManager.merge(endereco);
    }

    public void excluir (final Endereco endereco) {
        this.entityManager.remove(endereco);
    }

}
