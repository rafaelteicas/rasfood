package org.example.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "ordens_cardapio")
public class OrdensCardapio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private Ordem ordem;

    @ManyToOne(fetch = FetchType.LAZY)
    private Cardapio cardapio;

    @Column(name = "valor_de_registro")
    private BigDecimal valorDeRegistro;

    private Integer quantidade;

    public OrdensCardapio(Cardapio cardapio, int i) {
    }

    public OrdensCardapio(Cardapio cardapio, Integer quantidade, BigDecimal valorDeRegistro) {
        this.cardapio = cardapio;
        this.quantidade = quantidade;
        this.valorDeRegistro = valorDeRegistro;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Ordem getOrdem() {
        return ordem;
    }

    public void setOrdem(Ordem ordem) {
        this.ordem = ordem;
    }

    public Cardapio getCardapio() {
        return cardapio;
    }

    public void setCardapio(Cardapio cardapio) {
        this.cardapio = cardapio;
    }

    public BigDecimal getValor() {
        return valorDeRegistro;
    }

    public void setValor(BigDecimal valor) {
        this.valorDeRegistro = valor;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "OrdensCardapio{" +
                "id=" + id +
                ", cardapio=" + cardapio +
                ", valorDeRegistro=" + valorDeRegistro +
                ", quantidade=" + quantidade +
                '}';
    }
}
