package br.com.senai.entity;


public class ContaPoupanca extends Conta {
    private static final double RENDIMENTO = 0.15;

    public ContaPoupanca() {}

    public ContaPoupanca(String numeroConta, String agencia, String dataAbertura, double saldo) {
        super(numeroConta, agencia, dataAbertura, saldo);
    }

    public void aplicarRendimento() {
        double saldoAtual = getSaldo();
        double novoSaldo = saldoAtual + (saldoAtual * RENDIMENTO);
        setSaldo(novoSaldo);
    }
}