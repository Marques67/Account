package Entities;

import Factory.Factory;

import java.sql.*;
import java.util.Date;

public class Vip extends Client {

    @Override
    public Double getBalance() {
        try {
            Connection connection = Factory.getConnection();
            String sql = "SELECT balance FROM client WHERE Type = 'VIP'";
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet result = stmt.executeQuery();

            while (result.next()) {
                System.out.println("Seu saldo atual é: R$ " + result.getDouble("balance"));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return super.getBalance();
    }

    @Override
    public String extract() {
        try {
            Connection connection = Factory.getConnection();
            String sql = "SELECT balance FROM client WHERE Type = 'VIP'";
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet result = stmt.executeQuery();

            java.util.Date now = new Date();

            if (result.next()) {
                System.out.println("Saldo atual: " + result.getDouble("Balance") + " às " + now);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return super.extract();
    }

    @Override
    public void withdraw(double amount) {
        try {
            Connection connection = Factory.getConnection();
            String sql = "SELECT balance FROM client WHERE Type = 'VIP'";
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet result = stmt.executeQuery();

            if (result.next()) {
                Double balance = result.getDouble("balance");
                if(amount > result.getDouble("balance")) {
                    balance = balance - 7.0;
                    System.out.println("Saque realizado no valor de R$ " + amount);
                    System.out.println("Saldo atual: R$ " + balance);
                    System.out.println("Você está negativado!");
                }
                else {
                    balance = balance - amount;
                    System.out.println("Saque realizado no valor de R$ " + amount);
                    System.out.println("Saldo atual: R$ " + balance);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Integer accountNumber(Integer accountNumber) {
        try {
            Connection connection = Factory.getConnection();
            String sql = "SELECT Name FROM client WHERE AccountNumber = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, accountNumber);
            ResultSet result = stmt.executeQuery();

            if (result.next() == false) {
                System.out.println("Conta não existe");
                System.exit(0);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return accountNumber;
    }

    @Override
    public Integer password(Integer password) {
        try {
            Connection connection = Factory.getConnection();
            String sql = "SELECT AccountNumber FROM client WHERE passwor = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, password);
            ResultSet result = stmt.executeQuery();

            if (result.next() == false) {
                System.out.println("Senha incorreta!");
                System.exit(0);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return password;
    }

    @Override
    public void deposit(double amount) {
        try {
            Connection connection = Factory.getConnection();
            String sql = "SELECT balance FROM client WHERE Type = 'VIP'";
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet result = stmt.executeQuery();

            if (result.next()) {
                Double balance = result.getDouble("balance");
                balance = balance + amount;
                System.out.println("Saldo atual: R$ " + balance);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void transference(double amount) {
        try {
            Connection connection = Factory.getConnection();
            String sql = "SELECT balance FROM client WHERE Type = 'VIP'";
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet result = stmt.executeQuery();

            if (result.next()) {
                Double balance = result.getDouble("balance");
                balance = balance - amount - 0.08;
                System.out.println("Saldo atual: R$ " + balance);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}