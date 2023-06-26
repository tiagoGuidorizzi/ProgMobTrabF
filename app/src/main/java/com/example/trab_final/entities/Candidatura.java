package com.example.trab_final.entities;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import com.example.trab_final.dao.UsuarioDao;

@Entity(tableName = "candidaturas", foreignKeys = @ForeignKey(entity = Usuario.class,
        parentColumns = "id",
        childColumns = "idUsuario",
        onDelete = ForeignKey.CASCADE))
public class Candidatura {
    @PrimaryKey(autoGenerate = true)
    private long id;
    private long idUsuario;
    private String nome;
    private String descricao;
    private double salario;
    private String email;
    private String telefone;

    public Candidatura(){}

    public Candidatura(long idUsuario, String nome, String descricao, double salario, String email, String telefone) {
        this.idUsuario = idUsuario;
        this.nome = nome;
        this.descricao = descricao;
        this.salario = salario;
        this.email = email;
        this.telefone = telefone;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

}
