package org.example.service.test;

import org.example.dao.CardapioDao;
import org.example.dao.ClienteDao;
import org.example.dao.EnderecoDao;
import org.example.dao.OrdemDao;
import org.example.entity.*;
import org.example.util.CargaDeDadosUtil;
import org.example.util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class OrdemService {
    public static void main(String[] args) {
        EntityManager entityManager = JPAUtil.getEntityManagerRasFood();
        entityManager.getTransaction().begin();
        CargaDeDadosUtil.cadastrarCategoria(entityManager);
        CargaDeDadosUtil.cadastrarProdutosCardapio(entityManager);
        OrdemDao ordemDao = new OrdemDao(entityManager);

        System.out.println(ordemDao.consultarItemsMaisVendidos());

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
