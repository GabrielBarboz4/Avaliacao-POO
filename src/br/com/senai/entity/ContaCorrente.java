package br.com.senai.entity;


public class ContaCorrente extends Conta {
    private static final double TAXA_MANUTENCAO = 30.00;

    public ContaCorrente () {}

    public ContaCorrente(String numeroConta, String agencia, String dataAbertura, double saldo) {
        super(numeroConta, agencia, dataAbertura, saldo);
    }

    public double calcularTaxaManutencao() {
        return TAXA_MANUTENCAO;
    }
}
