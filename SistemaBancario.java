import java.util.Scanner;

public class SistemaBancario {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double saldo = 0.0;
        double limite = 200.0;
        String historico = "";
        int opcao;

        do {
            System.out.println("\n==========================");
            System.out.println("     SISTEMA BANCÁRIO");
            System.out.println("==========================");
            System.out.println("1 - Sacar");
            System.out.println("2 - Depositar");
            System.out.println("3 - Extrato");
            System.out.println("4 - Sair");
            System.out.println("==========================");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();

            switch (opcao) {

                case 1:
                    System.out.print("Digite o valor para saque: R$ ");
                    double saque = scanner.nextDouble();

                    if (saque <= 0) {
                        System.out.println("Erro: Digite um valor positivo.");

                    } else if (saque > saldo + limite) {
                        System.out.println("Erro: Saldo + limite insuficiente.");
                        System.out.printf("Você pode sacar até R$ %.2f%n", saldo + limite);

                    } else {
                        saldo -= saque;

                        historico += String.format(
                                "Saque de R$ %.2f%n", saque
                        );

                        System.out.println("Saque realizado com sucesso!");
                    }
                    break;

                case 2:
                    System.out.print("Digite o valor para depósito: R$ ");
                    double deposito = scanner.nextDouble();

                    if (deposito <= 0) {
                        System.out.println("Erro: Digite um valor positivo.");

                    } else {
                        saldo += deposito;

                        historico += String.format(
                                "Depósito de R$ %.2f%n", deposito
                        );

                        System.out.println("Depósito realizado com sucesso!");
                    }
                    break;

                case 3:
                    System.out.println("\n==========================");
                    System.out.println("       SEU EXTRATO");
                    System.out.println("==========================");

                    System.out.printf("Saldo atual: R$ %.2f%n", saldo);
                    System.out.printf("Limite disponível: R$ %.2f%n", limite);

                    System.out.println("\n--- HISTÓRICO ---");

                    if (historico.isEmpty()) {
                        System.out.println("Nenhuma operação realizada.");
                    } else {
                        System.out.print(historico);
                    }

                    System.out.println("==========================");
                    break;

                case 4:
                    System.out.println("\nObrigado por utilizar nosso sistema!");
                    break;

                default:
                    System.out.println("Opção inválida! Escolha uma opção de 1 a 4.");
            }

        } while (opcao != 4);

        scanner.close();
    }
}
