package br.com.senai.entity;

public class Conta {
    private String numeroConta;
    private String agencia;
    private String dataAbertura;
    private double saldo;

    public Conta(String numeroConta, String agencia, String dataAbertura, double saldo) {
        this.numeroConta = numeroConta;
        this.agencia = agencia;
        this.dataAbertura = dataAbertura;
        this.saldo = saldo;
    }

    public Conta() {
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(String dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

}