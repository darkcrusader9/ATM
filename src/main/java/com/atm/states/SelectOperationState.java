package com.atm.states;

import com.atm.ATM;
import com.atm.enums.TransactionType;
import com.atm.model.Card;

public class SelectOperationState extends ATMState{
    @Override
    public void selectOperation(ATM atm, Card card, TransactionType txnType){
        System.out.println("Please select the Operation");
        TransactionType.showAllTransactionTypes();

        switch (txnType){
            case CASH_WITHDRAWAL: {
                System.out.println("You have chosen to withdraw cash");
                atm.setAtmState(new CashWithdrawalState());
                break;
            }

            case DISPLAY_BALANCE: {
                System.out.println("You have chosen to display balance");
                atm.setAtmState(new DisplayBalanceState());
                break;
            }

            default: {
                System.out.println("Invalid Option");
                exit(atm);
            }
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
