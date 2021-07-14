package Entities;

import db.DB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class Client {

    private String name;
    private Integer accountNumber;
    private String type;
    private Double balance;

    public Client() {
    }

    public Client(String name, String type, Double balance) {
        this.name = name;
        this.type = type;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Integer accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public String extract() {
        Date now = new Date();
        return "Saldo atual: R$ " + getBalance() + "às " + now;
    }

    public void withdraw(double amount) {
    }

    public void deposit(double amount) {
        balance -= amount;
    }

    public void transference(double amount) {
        balance -= amount;
    }

    public void changeOfUser() {
        System.out.println("Você saiu!");
    }

}