package com.example.myapplicationsqllite;

public class Pessoa {
    protected String Rg;
    protected String nome;
    protected String email;

    public Pessoa(String rg, String nome, String email) {
        Rg = rg;
        this.nome = nome;
        this.email = email;
    }

    public String getRg() {
        return Rg;
    }

    public void setRg(String rg) {
        Rg = rg;
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
}
