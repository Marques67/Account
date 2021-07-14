package Entities;

import db.DB;

import java.sql.*;

public class Vip extends Client {

    @Override
    public Integer getAccountNumber() {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            conn = DB.getConnection();

            st = conn.createStatement();

            rs = st.executeQuery("SELECT AccountNumber FROM client WHERE Type = 'VIP'");

            while (rs.next()) {
                if(rs.getBoolean("AccountNumber") == true) {
                    System.out.println("Prossiga");
                }
                else {
                    System.out.println("Conta não encontrada!");
                }
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return super.getAccountNumber();
    }

    @Override
    public Double getBalance() {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            conn = DB.getConnection();

            st = conn.createStatement();

            rs = st.executeQuery("SELECT balance FROM client WHERE Type = 'VIP'");

            while (rs.next()) {
                System.out.println("Seu saldo atual é: R$ " + rs.getDouble("Balance"));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return super.getBalance();
    }

    @Override
    public String getType() {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            conn = DB.getConnection();

            st = conn.createStatement();

            rs = st.executeQuery("SELECT * FROM client WHERE Type = VIP ");

            System.out.println("Name: " + getName());
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return super.getType();
    }

    @Override
    public void withdraw(double amount) {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            conn = DB.getConnection();

            st = conn.createStatement();

            rs = st.executeQuery("SELECT balance FROM client WHERE Type = 'VIP'");

            while (rs.next()) {
                if(amount > rs.getDouble("Balance")) {
                    Double balance = rs.getDouble("Balance") - 0.01;
                    System.out.println("Saque realizado no valor de R$ " + amount);
                    System.out.println("Saldo atual: R$ " + balance);
                    System.out.println("Você está negativado!");
                }
                else {
                    Double balance = rs.getDouble("Balance") - amount;
                    System.out.println("Saque realizado no valor de R$ " + amount);
                    System.out.println("Saldo atual: R$ " + balance);
                }
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        if(amount > getBalance()) {
            Double balance = getBalance() - 0.01;
            System.out.println(balance);
        }
        else {
            System.out.println(getBalance());
        }
    }

    @Override
    public void transference(double amount) {
        Double balance = getBalance() - amount - 0.08;
        System.out.println("Saldo atual: R$ " + balance);
    }
}
