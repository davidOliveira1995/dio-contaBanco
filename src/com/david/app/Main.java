package com.david.app;

import com.david.model.ContaBanco;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        ContaBanco novaConta = null;
        boolean programaFinalizado = false;
        do {
            pulaLinha();
            System.out.println("Sejá bem vindo ao Banco Santander!");

            System.out.println("1. Abrir conta!");
            System.out.println("2. Informações da conta.");
            System.out.println("3. Fazer depósito.");
            System.out.println("4. Fazer saque.");
            System.out.println("5. Ver saldo.");
            System.out.println("6. Sair.");

            System.out.print("Digite a opção: ");
            int option = scan.nextInt();

            scan.nextLine();

            switch (option) {
                case 1:
                    System.out.println("Opção 1: Abrir conta.");

                    System.out.print("Nome do cliente: ");
                    String nome = scan.nextLine();

                    System.out.print("Agência: ");
                    String agencia = scan.nextLine();

                    System.out.print("Número da conta: ");
                    int numero = scan.nextInt();

                    scan.nextLine();

                    novaConta = new ContaBanco(numero, agencia, nome, 0);

                    System.out.println("Conta criada com sucesso!");
                    pulaLinha();
                    System.out.println("Olá " + novaConta.getNomeCliente() + " , obrigado por criar uma conta em nosso banco, sua agência é " + novaConta.getAgencia() + " , conta " + novaConta.getNumero() + " e seu saldo R$" + novaConta.getSaldo() +
                            " já está disponível para saque");
                    break;
                case 2:
                    if (novaConta == null) {
                        System.out.println("Nenhuma conta foi criada ainda. Por favor, crie uma conta primeiro.");
                        break;
                    }

                    System.out.println("Opção 2: Informações da conta.");

                    System.out.println(novaConta.toString());
                    break;
                case 3:
                    if (novaConta == null) {
                        System.out.println("Nenhuma conta foi criada ainda. Por favor, crie uma conta primeiro.");
                        break;
                    }

                    System.out.println("Opção 3: Fazer depósito.");

                    System.out.print("Valor: R$ ");
                    double valorDeposito = scan.nextDouble();

                    novaConta.fazerDeposito(valorDeposito);
                    System.out.println("Depósito realizado com sucesso!");
                    break;
                case 4:
                    if (novaConta == null) {
                        System.out.println("Nenhuma conta foi criada ainda. Por favor, crie uma conta primeiro.");
                        break;
                    }

                    System.out.println("Opção 4: Fazer saque.");
                    System.out.print("Valor: R$ ");
                    double valorSaque = scan.nextDouble();

                    if (novaConta.fazerSaque(valorSaque)) {
                        System.out.println("Saque realizado com sucesso!");
                    } else {
                        System.out.println("Saldo insuficiente. Saque não realizado.");
                    }
                    break;
                case 5:
                    if (novaConta == null) {
                        System.out.println("Nenhuma conta foi criada ainda. Por favor, crie uma conta primeiro.");
                        break;
                    }

                    System.out.println("Opção 5: Obter saldo.");
                    System.out.print("Saldo em conta: R$ " + novaConta.getSaldo());
                    break;
                case 6:
                    System.out.println("Opção 6: Sair");
                    System.out.println("Saindo...");
                    programaFinalizado = true;
                    break;
                default:
                    System.out.println("Opção inválida! Digite um número entre 1 a 6.");
            }

        }while (!programaFinalizado);

        scan.close();
    }

    public static void pulaLinha(){
        System.out.println();
    }
}