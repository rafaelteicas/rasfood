package org.example.dao;

import org.example.entity.Cardapio;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class CardapioDao {
    private EntityManager entityManager;

    public CardapioDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void cadastrar(final Cardapio cardapio) {
        this.entityManager.persist(cardapio);
    }

    public Cardapio consultarPorId(final Integer id) {
        return this.entityManager.find(Cardapio.class, id);
    }

    public List<Cardapio> consultarTodos() {
        String jpql = "SELECT c FROM Cardapio c";
        return this.entityManager.createQuery(jpql, Cardapio.class).getResultList();
    }

    public List<Cardapio> consultarPorValor(final BigDecimal valor) {
        String jpql = "SELECT c FROM Cardapio c WHERE c.valor = :valor";
        return this.entityManager.createQuery(jpql, Cardapio.class).setParameter("valor", valor).getResultList();
    }

    public void atualizar(final Cardapio cardapio) {
        this.entityManager.merge(cardapio);
    }

    public void excluir(final Cardapio cardapio) {
        this.entityManager.remove(cardapio);
    }
}
