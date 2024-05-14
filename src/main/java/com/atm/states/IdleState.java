package com.atm.states;

import com.atm.ATM;
import com.atm.model.Card;

public class IdleState extends ATMState{
    @Override
    public void insertCard(ATM atm, Card card){
        System.out.println("Card is inserted");
        atm.setAtmState(new HasCardState());
    }
}
