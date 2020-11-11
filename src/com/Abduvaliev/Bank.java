package com.Abduvaliev;

import java.util.Scanner;

public class Bank {
    public String name;
    public int id;
    private double balance;
    private double previousTrans;

    public Bank (String name, int id) {
        this.name = name;
        this.id = id;
    }

    public void makeDeposit (double amount) {
        if (amount != 0) {
            balance += amount;
            previousTrans = amount;
        }
    }

    public void makeWithDraw (double amount) {
        if (amount != 0) {
            balance -= amount;
            previousTrans = -balance;
        }
    }

    public void previousTransaction() {
        if (previousTrans > 0) {
            System.out.println("Deposited: " + previousTrans);
        } else if (previousTrans < 0) {
            System.out.println("Withdrawn: " + previousTrans);
        } else {
            System.out.println("No transaction occurred");
        }
    }

    public void calcInterest (int years) {
        double interestRate = .0185;
        double newBalance = (balance * interestRate * years) + balance;
        System.out.println("The current interest rate is " + (100 * interestRate) + "%");
        System.out.println("After " + years + " years, your balance will be: " + newBalance);
    }

    public void showMenu () {
        char option;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome, " + name + " to my bank!");
        System.out.println("Your id is: " + id);
        System.out.println();
        System.out.println("A: Check your balance");
        System.out.println("B: Make a deposit");
        System.out.println("C: Make a withdrawal");
        System.out.println("D: View the previous transaction");
        System.out.println("E: Calculate interest");
        System.out.println("F: Exit the application");

        do {
            System.out.println();
            System.out.println("Enter an option:");
            char input = scanner.next().charAt(0);
            option = Character.toUpperCase(input);
            System.out.println();

            switch (option) {
                case 'A':
                    System.out.println("=======================");
                    System.out.println("Balance = $" + balance);
                    System.out.println("=======================");
                    System.out.println();
                    break;
                case 'B':
                    System.out.println("Enter in a number to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    makeDeposit(depositAmount);
                    System.out.println();
                    break;
                case 'C':
                    System.out.println("Enter in a number to withdraw: ");
                    double drawAmount = scanner.nextDouble();
                    makeWithDraw(drawAmount);
                    System.out.println();
                    break;
                case 'D':
                    System.out.println("=======================");
                    previousTransaction();
                    System.out.println("=======================");
                    System.out.println();
                    break;
                case 'E':
                    System.out.println("Enter how many years of accrued interest: ");
                    int years = scanner.nextInt();
                    calcInterest(years);
                    System.out.println();
                    break;
                case 'F':
                    System.out.println("=======================");
                    break;
                default:
                    System.out.println("Error: invalid option. Please enter A, B, C, D, E or F.");
                    break;
            }
        } while (option != 'F');
        System.out.println("Thank you for banking with us!");
    }
}
