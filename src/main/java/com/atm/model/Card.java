package com.atm.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Card {
    String cardId;
    int pin;
    Account account;

    public Card(String cardId, int pin, Account account) {
        this.cardId = cardId;
        this.pin = pin;
        this.account = account;
    }


    public int getBalance(){
        return account.getBalance();
    }

    public void deductBankBalance(int amount) {
        account.withdrawBalance(amount);
    }

    public void depositBankBalance(int amount){
        account.depositBalance(amount);
    }
}
