package Entities;

import java.util.Date;

public class Client {

    private String name;
    private Integer accountNumber;
    private Integer password;
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

    public Integer getAccountNumber() { return accountNumber; }

    public String getType() {
        return type;
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

    public void withdraw(double amount) { }

    public Integer accountNumber(Integer accountNumber) { return accountNumber; }

    public Integer password(Integer password) {
        return password;
    }

    public void deposit(double amount) { }

    public void transference(double amount) {
        balance -= amount;
    }

    public void changeOfUser() {
        System.out.println("Você saiu!");
    }

}