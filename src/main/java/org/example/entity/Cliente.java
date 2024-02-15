package org.example.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cliente")
public class Cliente {

    @EmbeddedId
    private ClienteId clienteId;

    private String nome;

    @Embedded
    private Contato contato;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Endereco> endereco = new ArrayList<>();

    public Cliente() {
    }

    public Cliente(String cpf, String email,String nome) {
        this.ClienteId clienteId = new ClienteId(email, cpf);
        this.nome = nome;
    }

    public void addEndereco(Endereco endereco) {
        endereco.setCliente(this);
        this.endereco.add(endereco);
    }

    public Contato getContato() {
        return contato;
    }

    public void setContato(Contato contato) {
        this.contato = contato;
    }

    public String getCpf() {
        return clienteId.getCpf();
    }

    public void setCpf(String cpf) { clienteId.setCpf(cpf); }

    public String getEmail() {
        return clienteId.getEmail();
    }

    public void setEmail(String email) {
        clienteId.setEmail(email);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Endereco> getEndereco() {
        return endereco;
    }

    public void setEndereco(List<Endereco> endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "cpf='" + clienteId.getCpf() + '\'' +
                "email='" + clienteId.getEmail() + '\'' +
                ", nome='" + nome + '\'' +
                ", contato=" + contato +
                ", endereco=" + endereco +
                '}';
    }
}
