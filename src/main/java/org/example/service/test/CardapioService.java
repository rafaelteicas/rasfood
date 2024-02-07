package org.example.service.test;

import org.example.dao.CardapioDao;
import org.example.entity.Cardapio;
import org.example.util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class CardapioService {
    public static void main(String[] args) {
        Cardapio risoto = new Cardapio();
        risoto.setNome("Risoto de frutos do mar");
        risoto.setDescricao("Risoto acompanhado de lula, polvo e mariscos.");
        risoto.setDisponivel(true);
        risoto.setValor(BigDecimal.valueOf(88.50));

        Cardapio salmao = new Cardapio();
        salmao.setNome("Salmão ao molho de maracuja");
        salmao.setDescricao("Salmão grelhado ao molho de maracuja");
        salmao.setDisponivel(true);
        salmao.setValor(BigDecimal.valueOf(60.00));

        EntityManager entityManager = JPAUtil.getEntityManagerRasFood();
        CardapioDao cardapioDao = new CardapioDao(entityManager);

        entityManager.getTransaction().begin();

        cardapioDao.cadastrar(risoto);
        entityManager.flush();

        cardapioDao.cadastrar(salmao);
        entityManager.flush();

        System.out.println("O prato consultado foi: " + cardapioDao.consultar(2));

        cardapioDao.excluir(salmao);

        entityManager.clear();

        risoto.setValor(BigDecimal.valueOf(75.50));

        cardapioDao.atualizar(risoto);

        System.out.println("O prato consultado foi: " + cardapioDao.consultar(1));

    }
}
