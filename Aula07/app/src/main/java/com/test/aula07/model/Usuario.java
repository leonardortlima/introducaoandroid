package com.test.aula07.model;

import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;
import android.util.Log;

import com.test.aula07.dao.UsuarioDAO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Usuario implements Serializable {

    private long id;
    private String nome;
    private String email;
    private String celular;
    private String cor;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public Usuario salvar(SQLiteDatabase db) {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        try {
            return usuarioDAO.salvar(db, this);
        } catch (Exception e) {
            Log.e("Usuario","Erro ao salvar", e);
            return this;
        }
    }

    public boolean alterar(SQLiteDatabase db) {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        try {
            return usuarioDAO.alterar(db, this);
        } catch (Exception e) {
            Log.e("Usuario", "Erro ao alterar", e);
            return false;
        }
    }

    public static List<Usuario> listar(SQLiteDatabase db) {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        try {
            return usuarioDAO.listar(db);
        } catch (Exception e) {
            Log.e("Usuario","Erro ao listar", e);
            return new ArrayList<>();
        }
    }

    public boolean apagar(SQLiteDatabase db) {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        try {
            return usuarioDAO.apagar(db, this);
        } catch (Exception e) {
            Log.e("Usuario","Erro ao apagar", e);
            return false;
        }
    }
}
