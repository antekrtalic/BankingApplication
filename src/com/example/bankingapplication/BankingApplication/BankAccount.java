package com.example.bankingapplication.BankingApplication;

import java.util.Scanner;

public class BankAccount {
    int balance;
    int previousTransaction;
    String customerID;
    String customerName;

    public BankAccount(String customerID, String customerName) {
        this.customerID = customerID;
        this.customerName = customerName;
    }

    public int getBalance() {
        return this.balance;
    }

    public String getCustomerID() {
        return this.customerID;
    }

    public String getCustomerName() {
        return this.customerName;
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

    public void showMenu() {
        char option = '\0';
        int amount = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome " + this.getCustomerName() + "!");
        System.out.println("Your ID is " + this.getCustomerID() + "!");
        System.out.println("\n");
        System.out.println("What do you want to do?");
        System.out.println("A. Check Balance");
        System.out.println("B. Deposit");
        System.out.println("C. Withdraw");
        System.out.println("D. Previous transaction");
        System.out.println("E. Exit");

        do {
            System.out.println("=============================================================");
            System.out.println("Enter an option:");
            option = scanner.next().charAt(0);
            System.out.println("=============================================================");

            switch(option) {
                case 'A':
                    System.out.println("Balance: " + this.getBalance());
                    break;
                case 'B':
                    System.out.println("Enter amount to add:");
                    amount = scanner.nextInt();
                    this.deposit(amount);
                    break;
                case 'C':
                    System.out.println("Enter amount to withdraw:");
                    amount = scanner.nextInt();
                    this.withdraw(amount);
                    break;
                case 'D':
                    this.cardTransactionMessage();
                    break;
                case 'E':
                    System.out.println("\n");
                    System.out.println("You're out!");
                    break;
                default:
                    System.out.println("Invalid option! Please use command from list!");
                    break;
            }

        } while(option != 'E');
    }
}
