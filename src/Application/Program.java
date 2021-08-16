package Application;

import Entities.Client;
import Entities.Normal;
import Entities.Vip;

import java.util.Locale;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        Client client = new Client();
        Client vip = new Vip();
        Client normal = new Normal();

        System.out.print("Olá! Você já possui uma conta no nosso banco? ");
        String answer = sc.next();
        if (answer.equals("Sim")) {
            System.out.print("Digite o tipo da sua conta: ");
            String type = sc.next();
            if (type.equals("VIP")) {
                System.out.print("Digite o número da sua conta: ");
                Integer number = sc.nextInt();
                vip.accountNumber(number);
                System.out.print("Digite a senha: ");
                Integer password = sc.nextInt();
                vip.password(password);
                System.out.println();
                vip.getName();
                System.out.println();

                System.out.println("1 - Saldo");
                System.out.println("2 - Extrato");
                System.out.println("3 - Saque");
                System.out.println("4 - Depósito");
                System.out.println("5 - Transferência");
                System.out.println("6 - Solicitar visita do gerente");
                System.out.println("7 - Trocar de usuário");
                Integer choise = sc.nextInt();

                switch (choise) {
                    case 1:
                        vip.getBalance();
                        break;
                    case 2:
                        vip.extract();
                        break;
                    case 3:
                        System.out.print("Digite o valor do saque: R$ ");
                        double amount = sc.nextDouble();
                        vip.withdraw(amount);
                        break;
                    case 4:
                        System.out.print("Digite o valor do depósito: R$ ");
                        double deposit = sc.nextDouble();
                        vip.deposit(deposit);
                        break;
                    case 5:
                        System.out.print("Digite o valor da transferência: R$ ");
                        double transference = sc.nextDouble();
                        vip.transference(transference);
                        break;
                    case 6:
                        System.out.println("Visita solicitada!");
                        break;
                    case 7:
                        client.changeOfUser();
                        break;
                }
            }
            else if (type.equals("Normal")) {
                System.out.print("Digite o número da sua conta: ");
                Integer number = sc.nextInt();
                normal.accountNumber(number);
                System.out.print("Digite a senha: ");
                Integer password = sc.nextInt();
                normal.password(password);
                System.out.println();
                normal.getName();
                System.out.println();

                System.out.println("1 - Saldo");
                System.out.println("2 - Extrato");
                System.out.println("3 - Saque");
                System.out.println("4 - Depósito");
                System.out.println("5 - Transferência");
                System.out.println("6 - Trocar de usuário");
                Integer choise = sc.nextInt();

                switch (choise) {
                    case 1:
                        normal.getBalance();
                        break;
                    case 2:
                        normal.extract();
                        break;
                    case 3:
                        System.out.print("Digite o valor de saque: R$ ");
                        double amount = sc.nextDouble();
                        normal.withdraw(amount);
                        break;
                    case 4:
                        double deposit = sc.nextDouble();
                        normal.deposit(deposit);
                        break;
                    case 5:
                        System.out.print("Digite o valor da transferência: R$ ");
                        double transference = sc.nextDouble();
                        normal.transference(transference);
                        break;
                    case 6:
                        client.changeOfUser();
                        break;
                }
            }
        }
        sc.close();
    }
}
