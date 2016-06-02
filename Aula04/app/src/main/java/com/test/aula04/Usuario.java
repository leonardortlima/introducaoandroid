package com.test.aula04;

import java.io.Serializable;

/**
 * Class description.
 * <p/>
 * Created by Leonardo on 24/04/2015.
 */
public class Usuario implements Serializable {

    private String nome;
    private String email;
    private String celular;
    private String cor;

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
}
