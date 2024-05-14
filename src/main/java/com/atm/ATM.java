package com.atm;

import com.atm.states.IdleState;
import lombok.Getter;
import lombok.Setter;
import com.atm.states.ATMState;


public class ATM {
    private static ATM atmObject = new ATM(); //Singleton: eager initialization

    private ATM(){

    }

    @Setter
    @Getter
    ATMState atmState;
    @Setter
    @Getter
    private int atmBalance;
    int noOfTwoThousandNotes;
    int noOfFiveHundredNotes;
    int noOfOneHundredNotes;

    public static ATM getATMObject() {
        atmObject.setAtmState(new IdleState());
        return atmObject;
    }

    public void setAtmBalance(int noOfTwoThousandNotes, int noOfFiveHundredNotes, int noOfOneHundredNotes) {
        this.atmBalance = noOfTwoThousandNotes * 2000 + noOfFiveHundredNotes * 500 + noOfOneHundredNotes * 100;
        this.noOfTwoThousandNotes = noOfTwoThousandNotes;
        this.noOfFiveHundredNotes = noOfFiveHundredNotes;
        this.noOfOneHundredNotes = noOfOneHundredNotes;
    }

    public int getNoOfTwoThousandNotes() {
        return noOfTwoThousandNotes;
    }

    public int getNoOfFiveHundredNotes() {
        return noOfFiveHundredNotes;
    }

    public int getNoOfOneHundredNotes() {
        return noOfOneHundredNotes;
    }

    public void deductATMBalance(int amount) {
        int remainingAmount = amount;

        int numOf2000ToDispense = Math.min(remainingAmount / 2000, noOfTwoThousandNotes);
        remainingAmount -= numOf2000ToDispense * 2000;

        int numOf500ToDispense = Math.min(remainingAmount / 500, noOfFiveHundredNotes);
        remainingAmount -= numOf500ToDispense * 500;

        int numOf100ToDispense = Math.min(remainingAmount / 100, noOfOneHundredNotes);
        remainingAmount -= numOf100ToDispense * 100;

        if (remainingAmount != 0) {
            System.out.println("ATM cannot dispense the requested amount.");
            return;
        }

        atmBalance -= amount;
        noOfOneHundredNotes -= numOf2000ToDispense;
        noOfOneHundredNotes -= numOf500ToDispense;
        noOfOneHundredNotes -= numOf100ToDispense;

        System.out.println("Dispensed notes:");
        System.out.println("2000 Rupee Notes: " + numOf2000ToDispense);
        System.out.println("500 Rupee Notes: " + numOf500ToDispense);
        System.out.println("100 Rupee Notes: " + numOf100ToDispense);
    }

    public void deductTwoThousandNotes(int number) {
        noOfTwoThousandNotes = noOfTwoThousandNotes - number;
    }

    public void deductFiveHundredNotes(int number) {
        noOfFiveHundredNotes = noOfFiveHundredNotes - number;
    }

    public void deductOneHundredNotes(int number) {
        noOfOneHundredNotes = noOfOneHundredNotes - number;
    }

    public void printCurrentATMStatus(){
        System.out.println("Balance: " + atmBalance);
        System.out.println("2kNotes: " + noOfTwoThousandNotes);
        System.out.println("500Notes: " + noOfFiveHundredNotes);
        System.out.println("100Notes: " + noOfOneHundredNotes);
    }
}
