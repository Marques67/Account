package Application;

import Entities.Client;
import Entities.Normal;
import Entities.Vip;
import db.DB;

import java.sql.Connection;
import java.util.Locale;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        Client client = new Client();
        Client vip = new Vip();
        Client normal = new Normal();

        System.out.println("Olá");
        System.out.print("Digite o tipo da sua conta: ");
        String type = sc.next();
        if (type.equals("vip")) {
            System.out.print("Digite o número da sua conta: ");
            Integer number = sc.nextInt();
            System.out.println(vip.getType());
            if (number == vip.getAccountNumber()) {
                System.out.println("Conta não encontrada!");
            }
            else {
                System.out.println("Digite a opção desejada: ");
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
                        double deposit = sc.nextInt();
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
        } else {
            System.out.println("Digite a opção desejada: ");
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
                    double deposit = sc.nextInt();
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
        sc.close();
    }
}