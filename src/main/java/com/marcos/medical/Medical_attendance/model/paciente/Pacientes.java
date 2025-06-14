package com.marcos.medical.Medical_attendance.model.paciente;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Pacientes {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private int id;
    private String nome;
    private int idade;
    private long contacto;
    private String pass;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getIdade() {
        return idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }
    public long getContacto() {
        return contacto;
    }
    public void setContacto(long contacto) {
        this.contacto = contacto;
    }
    public String getPass() {
        return pass;
    }
    public void setPass(String pass) {
        this.pass = pass;
    }

    @Override
    public String toString() {
        return "Pacientes [id=" + id + ", nome=" + nome + ", idade=" + idade + ", contacto=" + contacto + ", pass=" + pass + "]";
    }
}
