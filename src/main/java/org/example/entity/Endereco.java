package org.example.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "endereco")
public class Endereco {

    private Integer id;

    private String cep;

    private String rua;

    private String estado;

    private String cidade;

    private String complemento;

    private Cliente cliente;

    public Endereco() { }

    public Endereco(Integer id, String cep, String rua, String estado, String cidade, String complemento, Cliente cliente) {
        this.id = id;
        this.cep = cep;
        this.rua = rua;
        this.estado = estado;
        this.cidade = cidade;
        this.complemento = complemento;
        this.cliente = cliente;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "Endereco{" +
                "id=" + id +
                ", cep='" + cep + '\'' +
                ", rua='" + rua + '\'' +
                ", estado='" + estado + '\'' +
                ", cidade='" + cidade + '\'' +
                ", complemento='" + complemento + '\'' +
                ", cliente=" + cliente +
                '}';
    }
}
