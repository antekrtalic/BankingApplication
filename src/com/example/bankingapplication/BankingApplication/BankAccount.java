package com.example.bankingapplication.BankingApplication;

public class BankAccount {
    int balance;
    int previousTransaction;
    String customerID;
    String customerName;

    public BankAccount(int balance, int previousTransaction, String customerID, String customerName) {
        this.balance = balance;
        this.previousTransaction = previousTransaction;
        this.customerID = customerID;
        this.customerName = customerName;
    }

    public void deposit(int amount) {
        if(amount != 0) {
            this.balance = this.balance + amount;
            this.previousTransaction = amount;
        }
    }

    public void withdraw(int amount) {
        if (amount >= 0) {
            this.balance = this.balance - amount;
            this.previousTransaction = -amount;
        }
    }

    public int getPreviousTransaction() {
        return this.previousTransaction;
    }

    public void cardTransactionMessage() {
        if (this.previousTransaction > 0) {
            System.out.println("Deposited: " + this.previousTransaction);
        } else if (this.previousTransaction < 0) {
            System.out.println("Withdraw: " + this.previousTransaction);
        }
    }
}
