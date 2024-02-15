package org.example.dao;

import org.example.entity.Endereco;
import org.example.vo.ClienteVo;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Objects;

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

    public List<ClienteVo> consultarClientes(final String estado, final String cidade, final String rua) {
        String jpql = "SELECT new org.example.vo.ClienteVo(e.cliente.clientId.cpf, e.cliente.nome)" +
                "FROM Endereco e WHERE 1=1";

        if(Objects.nonNull(estado)) {
            jpql = jpql.concat("AND UPPER(e.estado) = UPPER(:estado) ");
        }
        if(Objects.nonNull(cidade)) {
            jpql = jpql.concat("AND UPPER(e.cidade) = UPPER(:cidade) ");
        }
        if(Objects.nonNull(rua)) {
            jpql = jpql.concat("AND UPPER(e.rua) = UPPER(:rua) ");
        }
        TypedQuery typedQuery = this.entityManager
                .createQuery(jpql, ClienteVo.class);

        if(Objects.nonNull(estado)) {
            typedQuery.setParameter("estado", estado);
        }
        if(Objects.nonNull(cidade)) {
            typedQuery.setParameter("cidade", cidade);
        }
        if(Objects.nonNull(rua)) {
            typedQuery.setParameter("rua", rua);
        }

        return typedQuery.getResultList();
    }

    public List<ClienteVo> consultarClientesUsandoCriteria(final String estado, final String cidade, final String rua) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<ClienteVo> criteriaQuery = builder.createQuery(ClienteVo.class);
        Root<Endereco> root = criteriaQuery.from(Endereco.class);
        criteriaQuery.multiselect(root.get("cliente").get("clientId").get("cpf"), root.get("cliente").get("nome"));
        Predicate predicate=builder.and();

        if(Objects.nonNull(estado)) {
            predicate = builder.and(predicate, builder.equal(builder.upper(root.get("estado")), estado.toUpperCase()));
        }
        if(Objects.nonNull(cidade)) {
            predicate = builder.and(predicate, builder.equal(builder.upper(root.get("cidade")), cidade.toUpperCase()));
        }
        if(Objects.nonNull(rua)) {
            predicate = builder.and(predicate, builder.equal(builder.upper(root.get("rua")), rua.toUpperCase()));
        }
        criteriaQuery.where(predicate);
        return entityManager.createQuery(criteriaQuery).getResultList();
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
