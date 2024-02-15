package org.example.vo;

public class ItemsPrincipaisVo {
    private String nome;
    private Long quantidade;

    public ItemsPrincipaisVo(String nome, Long quantidade) {
        this.nome = nome;
        this.quantidade = quantidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Long quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "ItemsPrincipaisVo{" +
                "nome='" + nome + '\'' +
                ", quantidade=" + quantidade +
                '}';
    }
}
