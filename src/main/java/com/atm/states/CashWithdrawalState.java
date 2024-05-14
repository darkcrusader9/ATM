package com.atm.states;

import com.atm.ATM;
import com.atm.model.Card;

public class CashWithdrawalState extends ATMState{
    public void cashWithdraw(ATM atm, Card card, int withdrawAmt) {
        System.out.println("Requested amount is " + withdrawAmt);
        atm.deductATMBalance(withdrawAmt);
        card.deductBankBalance(withdrawAmt);
        atm.setAtmState(new IdleState());
    }

}
