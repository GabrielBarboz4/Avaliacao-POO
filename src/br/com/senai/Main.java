package br.com.senai;

import br.com.senai.entity.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<Pessoa> pessoas = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Bem vindo ao sistema de cadastro bancário da TechSYS");
        while (true) {
            System.out.println("Menu Techsys");
            System.out.println("1. Cadastrar Pessoa");
            System.out.println("2. Listar Pessoas");
            System.out.println("3. Editar Conta");
            System.out.println("4. Sair");
            System.out.print("Digite a escolha --> ");

            int escolha = scanner.nextInt();
            scanner.nextLine();

            switch (escolha) {
                case 1:
                    cadastrarPessoa();
                    break;
                case 2:
                    if (pessoas.isEmpty()) {
                    System.out.println("Não há cadastros no sistema, realize ao menos um cadastro antes de listar os dados");
                        System.out.println();
                    break;
                }
                    listarPessoas();
                    break;
                case 3:
                    if (pessoas.isEmpty()) {
                        System.out.println("Não há cadastros no sistema, realize ao menos um cadastro antes de listar os dados");
                        System.out.println();
                        break;
                    }
                    editarConta();
                    break;
                case 4:
                    System.out.println("Sistema finalizado com sucesso");
                    System.out.println("Até a proxima!");
                    return;
                default:
                    System.out.println("Opção inválida, retornando ao menu principal.");
            }
        }
    }

    private static void cadastrarPessoa() {
        System.out.println();
        System.out.print("Nome da pessoa: ");
        String nome = scanner.nextLine();
        System.out.print("Tipo de conta (1. Corrente, 2. Poupança, 3. Salário): ");
        int tipoConta = scanner.nextInt();
        if (tipoConta > 4 || tipoConta < 0) {
            System.out.println("Digite um valor válido");
            tipoConta = scanner.nextInt();
        }
        scanner.nextLine();
        System.out.print("Número da conta: ");
        String numeroConta = scanner.nextLine();
        System.out.print("Agência: ");
        String agencia = scanner.nextLine();
        System.out.print("Data de abertura (dia / mês / ano): ");
        String dataAbertura = scanner.nextLine();
        System.out.print("Saldo inicial: ");
        double saldo = scanner.nextDouble();
        scanner.nextLine();
        System.out.println();

        Conta conta;
        switch (tipoConta) {
            case 1:
                conta = new ContaCorrente (numeroConta, agencia, dataAbertura, saldo);
                break;
            case 2:
                conta = new ContaPoupanca(numeroConta, agencia, dataAbertura, saldo);
                break;
            case 3:
                conta = new ContaSalario(numeroConta, agencia, dataAbertura, saldo);
                break;
            default:
                System.out.println("Tipo de conta inválido.");
                return;
        }

        Pessoa pessoa = new Pessoa(nome);
        pessoa.setConta(conta);
        pessoas.add(pessoa);

        System.out.println("Pessoa cadastrada com sucesso!");
        System.out.println();
    }

    private static void listarPessoas() {
        for (Pessoa pessoa : pessoas) {
            System.out.println();
            System.out.println("Nome: " + pessoa.getNome());
            Conta conta = pessoa.getConta();
            System.out.println("Número da Conta: " + conta.getNumeroConta());
            System.out.println("Agência: " + conta.getAgencia());
            System.out.println("Data de Abertura: " + conta.getDataAbertura());
            System.out.println("Saldo: " + conta.getSaldo());
            System.out.println();
        }
    }
    private static void editarConta() {
        System.out.println();
        System.out.print("Digite o nome da pessoa para editar a conta: ");
        String nome = scanner.nextLine();

        Pessoa pessoa = null;

        for (Pessoa p : pessoas) {
            if (p.getNome().equalsIgnoreCase(nome)) {
                pessoa = p;
                break;
            }
        }

        if (pessoa == null) {
            System.out.println("Pessoa não encontrada.");
            return;
        }

        Conta conta = pessoa.getConta();
        boolean continuar = true;

        while (continuar) {
            System.out.println("\nEdição de Conta:");
            System.out.println("1. Editar número da conta");
            System.out.println("2. Editar agência");
            System.out.println("3. Editar saldo");
            if (conta instanceof ContaPoupanca) {
                System.out.println("4. Aplicar rendimento");
            }
            if (conta instanceof ContaSalario) {
                System.out.println("5. Registrar transação");
            }
            System.out.println("6. Voltar ao menu");
            System.out.print("Digite a opção desejada --> ");

            int escolha = scanner.nextInt();
            scanner.nextLine();

            switch (escolha) {
                case 1:
                    System.out.println();
                    System.out.print("Novo número da conta: ");
                    String novoNumeroConta = scanner.nextLine();
                    conta.setNumeroConta(novoNumeroConta);
                    System.out.println("Número da conta atualizado.");
                    break;
                case 2:
                    System.out.println();
                    System.out.print("Nova agência: ");
                    String novaAgencia = scanner.nextLine();
                    conta.setAgencia(novaAgencia);
                    System.out.println("Agência atualizada.");
                    break;
                case 3:
                    System.out.println();
                    System.out.print("Novo saldo: ");
                    double novoSaldo = scanner.nextDouble();
                    scanner.nextLine();
                    conta.setSaldo(novoSaldo);
                    System.out.println("Saldo atualizado.");
                    break;
                case 4:
                    System.out.println();
                    if (conta instanceof ContaPoupanca) {
                        ((ContaPoupanca) conta).aplicarRendimento();
                        System.out.println("Rendimento aplicado para conta poupança.");
                    } else {
                        System.out.println("Ação não disponível para este tipo de conta.");
                    }
                    break;
                case 5:
                    System.out.println();
                    if (conta instanceof ContaSalario) {
                        ((ContaSalario) conta).registrarTransacao();
                        System.out.println("Transação registrada para conta salário.");
                    } else {
                        System.out.println("Ação não disponível para este tipo de conta.");
                    }
                    break;
                case 6:
                    System.out.println();
                    System.out.println("Voltando ao menu...");
                    continuar = false;
                    System.out.println();
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }

            if (escolha >= 1 && escolha <= 5) {
                System.out.println("Saldo atual da conta: " + conta.getSaldo());
            }
        }
    }
}
