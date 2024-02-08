package org.example.util;

import org.example.dao.CardapioDao;
import org.example.dao.CategoriaDao;
import org.example.entity.Cardapio;
import org.example.entity.Categoria;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class CargaDeDadosUtil {
    public CargaDeDadosUtil() {
    }

    public static void cadastrarCategoria(EntityManager entityManager) {
        Categoria entrada = new Categoria("Entrada");
        Categoria saladas = new Categoria("Saladas");
        Categoria principal = new Categoria("Pratos principais");

        CategoriaDao categoriaDao = new CategoriaDao(entityManager);

        categoriaDao.cadastrar(entrada);
        entityManager.flush();

        categoriaDao.cadastrar(saladas);
        entityManager.flush();

        categoriaDao.cadastrar(principal);
        entityManager.flush();

    }

    public static void cadastrarProdutosCardapio(EntityManager entityManager) {
        CategoriaDao categoriaDao = new CategoriaDao(entityManager);
        CardapioDao cardapioDao = new CardapioDao(entityManager);

        List<Categoria> categorias = categoriaDao.consultarTodos();

        Cardapio risoto = new Cardapio("Risoto de frutos do mar", "Risoto acompanhado de lula, polvo e mariscos.", true, BigDecimal.valueOf(88.50), categorias.get(2));
        Cardapio salmao = new Cardapio("Salmão ao molho de maracuja", "Salmão grelhado ao molho de maracuja", true, BigDecimal.valueOf(60.00), categorias.get(2));

        cardapioDao.cadastrar(risoto);
        cardapioDao.cadastrar(salmao);

        entityManager.flush();
        entityManager.clear();
    }
}
