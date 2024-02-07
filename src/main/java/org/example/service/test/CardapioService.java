package org.example.service.test;

import org.example.dao.CardapioDao;
import org.example.util.CargaDeDadosUtil;
import org.example.util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class CardapioService {
    public static void main(String[] args) {
        EntityManager entityManager = JPAUtil.getEntityManagerRasFood();
        entityManager.getTransaction().begin();
        CargaDeDadosUtil.cadastrarCategoria(entityManager);
        CargaDeDadosUtil.cadastrarProdutosCardapio(entityManager);
        CardapioDao cardapioDao = new CardapioDao(entityManager);
        System.out.println("Lista de produtos por valor: " + cardapioDao.consultarPorValor(BigDecimal.valueOf(88.50)));
        System.out.println("Consulta por nome: " + cardapioDao.consultarPorNome("Salmão"));
        entityManager.close();
    }
}
