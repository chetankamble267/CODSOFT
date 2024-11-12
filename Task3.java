package com.solution.main;

import java.util.Scanner;
class Bank {
 private double balance;

 public Bank(double initialBalance) {
     this.balance = initialBalance;
 }

 public void deposit(double amount) {
     if (amount > 0) {
         balance += amount;
         System.out.println("Successfully deposited Money: $" + amount);
     } else {
         System.out.println("Invalid deposit amount.");
     }
 }

 public boolean withdraw(double amount) {
     if (amount > 0 && amount <= balance) {
         balance -= amount;
         System.out.println("Successfully withdraw done: $" + amount);
         return true;
     } else if (amount > balance) {
         System.out.println("Insufficient balance.");
         return false;
     } else {
         System.out.println("Invalid withdrawal amount.");
         return false;
     }
 }

 public double getBalance() {
     return balance;
 }
}

class ATM {
 private Bank account;
 private Scanner scanner;

 public ATM(Bank account) {
     this.account = account;
     this.scanner = new Scanner(System.in);
 }

 public void showMenu() {
     int choice;
     do {
    	 System.out.println("-------------------------------------------------");
         System.out.println("\nATM Menu:");
         System.out.println("-------------------------------------------------");
         System.out.println("1. Check Balance");
         System.out.println("2. Deposit");
         System.out.println("3. Withdraw");
         System.out.println("4. Exit");
         System.out.println("-------------------------------------------------");
         System.out.print("Choose an option: ");
         choice = scanner.nextInt();

         switch (choice) {
             case 1:
                 checkBalance();
                 break;
             case 2:
                 deposit();
                 break;
             case 3:
                 withdraw();
                 break;
             case 4:
                 System.out.println("Thank you for using the ATM");
                 break;
             default:
                 System.out.println("Invalid choice. Please try again.");
         }
     } while (choice != 4);
 }

 private void checkBalance() {
     System.out.println("Your current balance is: $" + account.getBalance());
 }

 private void deposit() {
     System.out.print("Enter amount to deposit: ");
     double amount = scanner.nextDouble();
     account.deposit(amount);
 }

 private void withdraw() {
     System.out.print("Enter amount to withdraw: ");
     double amount = scanner.nextDouble();
     account.withdraw(amount);
 }
}

public class Task3 {
 public static void main(String[] args) {
     Bank account = new Bank(1000.00);

     ATM atm = new ATM(account);

     atm.showMenu();
 }
}

