package com.example.myapplicationsqllite;

public class Aluno extends Pessoa{
    private String Ra;
    private String curso;

    public Aluno(String rg, String nome, String email, String Ra,String curso) {
        super(rg, nome, email);
        this.Ra = Ra;
        this.curso = curso;
    }

    public String getRa() {
        return Ra;
    }

    public void setRa(String ra) {
        Ra = ra;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    @Override
    public String toString() {
        return "Nome= " + nome +  "\n" +  " Ra= " + Ra ;
    }
}
