package com.noxtec.agendamentotelefonico.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "contato")
public class Contato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100)
    private String nome;

    private String email;

    @Column( unique=true, nullable=false,length = 11)
    private String celular;

    @Column(length = 10)
    private String telefone;

    private boolean favorito;

    private boolean ativo;

    @JsonFormat(pattern="yyyy-MM-dd")
    private Date data_cadastro;

    public Contato(){

    }

    public Contato(Long id, String nome, String email, String celular, String telefone, boolean favorito, boolean ativo, Date data_cadastro) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.celular = celular;
        this.telefone = telefone;
        this.favorito = favorito;
        this.ativo = ativo;
        this.data_cadastro = data_cadastro;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contato contato = (Contato) o;
        return favorito == contato.favorito && ativo == contato.ativo && Objects.equals(id, contato.id) && Objects.equals(nome, contato.nome) && Objects.equals(email, contato.email) && Objects.equals(celular, contato.celular) && Objects.equals(telefone, contato.telefone) && Objects.equals(data_cadastro, contato.data_cadastro);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, email, celular, telefone, favorito, ativo, data_cadastro);
    }

    @Override
    public String toString() {
        return "Contato{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", celular='" + celular + '\'' +
                ", telefone='" + telefone + '\'' +
                ", favorito=" + favorito +
                ", ativo=" + ativo +
                ", data_cadastro=" + data_cadastro +
                '}';
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public boolean isFavorito() {
        return favorito;
    }

    public void setFavorito(boolean favorito) {
        this.favorito = favorito;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public Date getData_cadastro() {
        return data_cadastro;
    }

    public void setData_cadastro(Date data_cadastro) {
        this.data_cadastro = data_cadastro;
    }
}
