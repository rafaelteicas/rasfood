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

        CardapioDao cardapioDao = new CardapioDao(entityManager);
        ClienteDao clienteDao = new ClienteDao(entityManager);
        OrdemDao ordemDao = new OrdemDao(entityManager);
        EnderecoDao enderecoDao = new EnderecoDao(entityManager);

        Endereco endereco = new Endereco("12345","12344", "12334","33223","1234123");

        enderecoDao.cadastrar(endereco);

        Cliente rafael = new Cliente("12345678", "Rafael");

        rafael.addEndereco(endereco);

        Ordem ordem = new Ordem(rafael);
        Cardapio cardapio = cardapioDao.consultarPorId(1);
        ordem.addOrdensCardapio(new OrdensCardapio(cardapio, 2, BigDecimal.valueOf(50.00)));
        clienteDao.cadastrar(rafael);
        ordemDao.cadastrar(ordem);

        System.out.println(ordem);

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
