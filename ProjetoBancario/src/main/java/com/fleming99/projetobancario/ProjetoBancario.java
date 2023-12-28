/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.fleming99.projetobancario;

import static java.lang.System.exit;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author rafae
 */
public class ProjetoBancario {

    static Scanner input = new Scanner(System.in);
    static ArrayList<Conta> contasBancarias;
        
    public static void main(String[] args) {
        
        contasBancarias = new ArrayList<>();
        operacoes();
    }
    
    public static void operacoes(){
        
        while(true){
            System.out.println("------------------------------------------------------");
            System.out.println("--------------Bem vindos a nossa Agência--------------");
            System.out.println("***** Selecione uma operação que deseja realizar *****");
            System.out.println("------------------------------------------------------");
            System.out.println("|   Opção 1 - Criar conta   |");
            System.out.println("|   Opção 2 - Depositar     |");
            System.out.println("|   Opção 3 - Saque         |");
            System.out.println("|   Opção 4 - Transferir    |");
            System.out.println("|   Opção 5 - Listar        |");
            System.out.println("|   Opção 6 - Sair          |");

            switch(input.nextInt()){
                case 1 -> criarConta();
                case 2 -> depositar();
                case 3 -> sacar();
                case 4 -> transferir();
                case 5 -> listar();
                case 6 -> exit(0);
                default -> {
                    System.out.println("Não foi possível encontrar a opção desejada");
                    operacoes();
                }
            }
        }
    }
    
    public static void criarConta(){
        
        System.out.println("\n");
        System.out.println("Qual é o seu nome? ");
        String nome = input.next();
        
        System.out.println("Digite seu CPF: ");
        String cpf = input.next();
        
        System.out.println("Digite seu RG: ");
        String rg = input.next();
        
        System.out.println("Digite seu e-mail: ");
        String email = input.next();
        
        System.out.println("Digite sua data de nascimento: (DD/MM/AAAA)");
        String birthdate =  input.next();
        Date dataAtual = new Date();
        
        Cliente cliente = new Cliente(nome, cpf, rg, email, birthdate, dataAtual);
        
        Conta conta = new Conta(cliente);
        
        contasBancarias.add(conta);
        
        System.out.println("Sua conta foi criada com sucesso!");
        
        operacoes();
    }
    
    private static Conta encontrarConta(int numeroConta){
        if(!contasBancarias.isEmpty()){
            for(Conta c : contasBancarias){
                if(c.getNumeroConta() == numeroConta){
                    return c;
                }
            }
        }else{
            System.out.println("Não há contas cadastradas.");
        }
        return null;
    }
    
    public static void depositar(){
        System.out.println("Digite o número da conta para deposito:");
        
        Conta conta = encontrarConta(input.nextInt());
        
        if(conta != null){
            System.out.println("Qual o valor que você deseja depositar?");
            conta.depositar(input.nextDouble());
            System.out.println("Valor transferido com sucesso!");
        }else{
            System.out.println("Conta não encontrada.");
        }
        operacoes();
    }
    
    public static void sacar(){
        System.out.println("Digite o numero da conta:");
        
        Conta conta = encontrarConta(input.nextInt());
        
        if(conta != null){
            System.out.println("Qual o valor que você deseja sacar?");
            conta.sacar(input.nextDouble());
        }else{
            System.out.println("Conta não encontrada.");
        }
        operacoes();
    }
    
    public static void transferir(){
        System.out.println("Digite o numero da conta que irá transferir o dinheiro:");
        
        Conta conta1 = encontrarConta(input.nextInt());
        
        if(conta1 != null){
            System.out.println("Digite o numero da conta que irá receber o dinheiro:");
            Conta conta2 = encontrarConta(input.nextInt());
            if (conta2 != null){
                System.out.println("Qual o valor que você deseja transferir??");
                conta1.transferir(conta2, input.nextDouble());
                System.out.println("Saque realizado com sucesso!");
            }else{
                System.out.println("Conta destino não foi encontrada.");
            }
        }else{
            System.out.println("Conta remetente não foi encontrada.");
        }
        operacoes();
    }
    
    public static void listar(){
        if(contasBancarias.isEmpty()){
            System.out.println("Não há contas cadastradas.");
            return;
        }
        for(Conta conta : contasBancarias){
            System.out.println(conta);
        }
    }
}
