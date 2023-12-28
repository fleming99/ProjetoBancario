/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fleming99.projetobancario;

import Utilitarios.Utils;

/**
 *
 * @author rafae
 */
public class Conta {
    
    private static int id = 1;
    
    private int numeroConta;
    private Cliente cliente;
    private double saldo = 0.0;

    public Conta(Cliente cliente) {
        this.numeroConta = id;
        this.cliente = cliente;
        id += 1;
    }
    
    public int getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
    }
    
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return """
               Dados Bancários:
               Numero da Conta: """ + this.getNumeroConta() +
               "\n" + this.getCliente().toString() +
               "\nSaldo: " + Utils.doubleToString(this.getSaldo()) +
                "\n";
    }
    
    public void depositar(double valor){
        if (valor > 0){
             setSaldo(getSaldo() + valor);
             System.out.println("Seu deposito foi realizado com sucesso.");
        }else{
            System.out.println("Não foi possível realizar o deposito.");
        }
    }
    
    public void sacar(double valor){
        if(valor > 0 && this.getSaldo() >= valor){
            setSaldo(this.getSaldo() - valor);
            System.out.println("Saque realizado com sucesso");
        }else{
            System.out.println("Não foi possível realizar o saque");
        }
    }
    
    public void transferir(Conta destino, double valor){
        if (valor > 0 && this.getSaldo() >= valor){
            setSaldo(this.getSaldo() - valor);
            destino.setSaldo(destino.getSaldo() + valor);
            System.out.println("Transferência realizada com sucesso");
        }else{
            System.out.println("Não foi possível realizar a transferência.");
        }
    }
    
}
