package com.david.model;

public class ContaBanco {

    private int numeroDaConta;
    private String agencia;
    private String nomeCliente;
    private double saldo;

    public ContaBanco(int numero, String agencia, String nomeCliente, double saldo) {
        this.numeroDaConta = numero;
        this.agencia = agencia;
        this.nomeCliente = nomeCliente;
        this.saldo = 0.0;
    }

    public int getNumero() {
        return numeroDaConta;
    }

    public void setNumero(int numero) {
        this.numeroDaConta = numero;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public double getSaldo() {
        return saldo;
    }


    @Override
    public String toString() {
        return "Nome do cliente: " + nomeCliente + "\n" +
                "Numero da conta: " + numeroDaConta + "\n" +
                "Agência: " + agencia + "\n" +
                "Saldo: R$ " + getSaldo();
    }

    public boolean fazerDeposito(double valor) {
        saldo += valor;
        return true;
    }

    public boolean fazerSaque(double valor) {
        if (saldo < valor) {
            return false;
        }
        saldo -= valor;
        return true;
    }
}
