package org.example.service;

import org.example.dao.PratoDao;
import org.example.entity.Prato;
import org.example.util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class PratoService {
    public static void main(String[] args) {
        Prato risoto = new Prato();
        risoto.setNome("Risoto de frutos do mar");
        risoto.setDescricao("Risoto acompanhado de lula, polvo e mariscos.");
        risoto.setDisponivel(true);
        risoto.setValor(BigDecimal.valueOf(88.50));

        Prato salmao = new Prato();
        salmao.setNome("Salmão ao molho de maracuja");
        salmao.setDescricao("Salmão grelhado ao molho de maracuja");
        salmao.setDisponivel(true);
        salmao.setValor(BigDecimal.valueOf(60.00));

        EntityManager entityManager = JPAUtil.getEntityManagerRasFood();
        PratoDao pratoDao = new PratoDao(entityManager);

        entityManager.getTransaction().begin();

        pratoDao.cadastrar(risoto);
        entityManager.flush();

        pratoDao.cadastrar(salmao);
        entityManager.flush();

        System.out.println("O prato consultado foi: " + pratoDao.consultar(2));

        pratoDao.excluir(salmao);

        entityManager.clear();

        risoto.setValor(BigDecimal.valueOf(75.50));

        pratoDao.atualizar(risoto);

        System.out.println("O prato consultado foi: " + pratoDao.consultar(1));

    }
}
