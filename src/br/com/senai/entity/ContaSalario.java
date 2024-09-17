package br.com.senai.entity;

public class ContaSalario extends Conta {
    private static final double TAXA_MANUTENCAO = 10.00;
    private int transacoesNoMes;

    public ContaSalario() {
        super();
        this.transacoesNoMes = 0;
    }

    public ContaSalario(String numeroConta, String agencia, String dataAbertura, double saldo) {
        super(numeroConta, agencia, dataAbertura, saldo);
        this.transacoesNoMes = 0;
    }

    public void registrarTransacao() {
        transacoesNoMes++;
        if (transacoesNoMes > 2) {
            double saldoAtual = getSaldo();
            setSaldo(saldoAtual - TAXA_MANUTENCAO);
        }
    }
}