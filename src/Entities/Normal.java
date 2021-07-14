package Entities;

import db.DB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Normal extends Client {

    @Override
    public Integer getAccountNumber() {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            conn = DB.getConnection();

            st = conn.createStatement();

            rs = st.executeQuery("SELECT AccountNumber FROM client WHERE Type = 'Normal'");

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
        finally {
            DB.closeResultSet(rs);
            DB.closeStatement(st);
            DB.closeConnection();
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

            rs = st.executeQuery("SELECT balance FROM client WHERE Type = 'Normal'");

            while (rs.next()) {
                System.out.println("Seu saldo atual é: R$ " + rs.getDouble("Balance"));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            DB.closeResultSet(rs);
            DB.closeStatement(st);
            DB.closeConnection();
        }
        return super.getBalance();
    }

    @Override
    public void withdraw(double amount) {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            conn = DB.getConnection();

            st = conn.createStatement();

            rs = st.executeQuery("SELECT balance FROM client WHERE Type = 'Normal'");

            while (rs.next()) {
                if(amount > rs.getDouble("Balance")) {
                    System.out.println("Saque solicitado maior que o saldo em conta");
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
        finally {
            DB.closeResultSet(rs);
            DB.closeStatement(st);
            DB.closeConnection();
        }
    }

    public void transference(double amount) {
        Double balance = getBalance() - amount - 8.00;
        System.out.println(balance);
    }
}
