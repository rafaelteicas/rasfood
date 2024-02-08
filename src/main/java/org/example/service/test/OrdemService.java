package org.example.service.test;

import org.example.dao.CardapioDao;
import org.example.dao.ClienteDao;
import org.example.dao.OrdemDao;
import org.example.entity.Cardapio;
import org.example.entity.Cliente;
import org.example.entity.Ordem;
import org.example.entity.OrdensCardapio;
import org.example.util.CargaDeDadosUtil;
import org.example.util.JPAUtil;

import javax.persistence.EntityManager;

public class OrdemService {
    public static void main(String[] args) {
        EntityManager entityManager = JPAUtil.getEntityManagerRasFood();
        entityManager.getTransaction().begin();
        CargaDeDadosUtil.cadastrarCategoria(entityManager);
        CargaDeDadosUtil.cadastrarProdutosCardapio(entityManager);

        CardapioDao cardapioDao = new CardapioDao(entityManager);
        ClienteDao clienteDao = new ClienteDao(entityManager);
        OrdemDao ordemDao = new OrdemDao(entityManager);

        Cliente rafael = new Cliente("12345678", "Rafael", "1211");
        Ordem ordem = new Ordem(rafael);
        Cardapio cardapio = cardapioDao.consultarPorId(1);
        ordem.addOrdensCardapio(new OrdensCardapio(cardapio, 2));
        clienteDao.cadastrar(rafael);
        ordemDao.cadastrar(ordem);

        System.out.println(ordem.getOrdensCardapioList());

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
