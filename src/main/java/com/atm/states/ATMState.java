package com.atm.states;

import com.atm.ATM;
import com.atm.enums.TransactionType;
import com.atm.model.Card;

import java.io.IOException;

public abstract class ATMState {
    public void insertCard(ATM atm, Card card){
        System.out.println("OOPS!! Something went wrong");
    }
    public void authenticatePIN(ATM atm, Card card, int pin) {
        System.out.println("OOPS!! Something went wrong");
    }

    public void selectOperation(ATM atm, Card card, TransactionType txnType){
        System.out.println("OOPS!! Something went wrong");
    }

    public void cashWithdraw(ATM atm, Card card, int withdrawAmt) {
        System.out.println("OOPS!! Something went wrong");
    }

    public void displayBalance(ATM atm, Card card){
        System.out.println("OOPS!! Something went wrong");
    }

    public void exit(ATM atm){
        System.out.println("OOPS!! Something went wrong");
    }

    public void collectCard(){
        System.out.println("OOPS!! Something went wrong");
    }
}
