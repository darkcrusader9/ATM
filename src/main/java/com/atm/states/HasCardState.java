package com.atm.states;

import com.atm.ATM;
import com.atm.model.Card;

public class HasCardState extends ATMState{
    @Override
    public void authenticatePIN(ATM atm, Card card, int pin)  {
        System.out.println("Enter your PIN");
        if(card.getPin() == pin){
            System.out.println("Authenticated");
            atm.setAtmState(new SelectOperationState());
        } else{
            System.out.println("Invalid PIN Number");
            exit(atm);
        }
    }

    @Override
    public void exit(ATM atm){
        collectCard();
        atm.setAtmState(new IdleState());
        System.out.println("You have been exited");
    }

    @Override
    public void collectCard(){
        System.out.println("Please collect your card");
    }
}
