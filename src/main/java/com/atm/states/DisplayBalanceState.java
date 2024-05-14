package com.atm.states;

import com.atm.ATM;
import com.atm.model.Card;

public class DisplayBalanceState extends ATMState{
    @Override
    public void displayBalance(ATM atm, Card card){
        System.out.println("Hello");
        System.out.println("Your Balance is: " + card.getBalance());
        exit(atm);
    }
    @Override
    public void exit(ATM atmObject){
        collectCard();
        atmObject.setAtmState(new IdleState());
        System.out.println("Exit happens");
    }

    @Override
    public void collectCard(){
        System.out.println("Please collect your card");
    }

}
