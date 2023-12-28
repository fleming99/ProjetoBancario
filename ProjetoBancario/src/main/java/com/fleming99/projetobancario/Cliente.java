/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fleming99.projetobancario;

import java.util.Date;

/**
 *
 * @author rafae
 */
public class Cliente {
    
    private static int id = 1;
    
    private String name;
    private String cpf;
    private String rg;
    private String email;
    private String birthDate;
    private Date creationDate;

    public Cliente(String name, String cpf, String rg, String email, String birthDate, Date creationDate) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.rg = rg;
        this.email = email;
        this.birthDate = birthDate;
        this.creationDate = creationDate;
        id += 1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public String toString() {
        return """
                Dados do Cliente:
                Nome do Cliente: """ + this.getName() +
                "\nCPF: " + this.getCpf() +
                "\nRG: " + this.getRg() +
                "\nE-mail: " + this.getEmail() +
                "\nData de Nascimento: " + this.getBirthDate() +
                "\nData de Criação da Conta: " + this.getCreationDate();
    }

    
    
    
}
