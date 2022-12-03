package com.company;

public class BankAccount {

    public static void checkBalance(int balance)
            throws IllegalArgumentException {
        if (balance <= 0)
            throw new IllegalArgumentException(balance + " must not be negative");
    }
}
