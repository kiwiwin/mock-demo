package org.kiwi.domain;

public class Payment {
    private int balance;

    public Payment(int balance) {
        this.balance = balance;
    }

    public void withdraw(int amount) {
        System.err.println("Hmm, We really take money from your account!");
        balance -= amount;
    }

    public int getBalance() {
        return balance;
    }
}
