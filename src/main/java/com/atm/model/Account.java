package com.atm.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Account {
    String accountId;
    int balance;

    public Account(String accountId, int balance) {
        this.accountId = accountId;
        this.balance = balance;
    }

    public void withdrawBalance(int amount) {
        if(amount <= balance)
            balance = balance - amount;
        else{
            System.out.println("Insufficient bank balance");
        }
    }

    public void depositBalance(int amount) {
        this.balance += amount;
    }
}
