package com.atm;

import com.atm.enums.TransactionType;
import com.atm.model.Account;
import com.atm.model.Card;
import com.atm.model.User;

public class ATMRoom {
    ATM atm;
    User user;

    public static void main(String[] args) {
        ATMRoom atmRoom = new ATMRoom();
        atmRoom.initialize();
        atmRoom.atm.printCurrentATMStatus();

        //ATM Operations
        atmRoom.atm.getAtmState().insertCard(atmRoom.atm, atmRoom.user.getCard());
        atmRoom.atm.getAtmState().authenticatePIN(atmRoom.atm, atmRoom.user.getCard(), 123);
        atmRoom.atm.getAtmState().selectOperation(atmRoom.atm, atmRoom.user.getCard(), TransactionType.CASH_WITHDRAWAL);
        atmRoom.atm.getAtmState().cashWithdraw(atmRoom.atm, atmRoom.user.getCard(), 1000);

        atmRoom.atm.printCurrentATMStatus();
    }

    private void initialize() {
        Account account = new Account("1", 5000);
        Card card = new Card("1234", 123, account);
        this.user = new User(card, account);
        this.atm = ATM.getATMObject();
        this.atm.setAtmBalance(5,3,2);

    }
}
