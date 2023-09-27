package com.techelevator;

import java.math.BigDecimal;

public class CoinBox {
    private static final String BANNER = "\n+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+\n";
    private int balance;

    public int getBalance() {
        return balance;
    }
    public void acceptDeposit(int deposit) {
        balance = (balance) + (deposit*100);
        System.out.println("You're current balance is: " + balance/100d);
    }
    public void makeChange() {
        int quarterCounter = 0;
        int dimeCounter = 0;
        int nickelCounter = 0;
        while (balance >= 25) {
            balance = balance - 25;
            quarterCounter++;
        }
        while (balance >= 10) {
            balance = balance - 10;
            dimeCounter++;
        }
        while (balance >= 5) {
            balance = balance - 5;
            nickelCounter++;
        }
        System.out.println("Your change is: \n" + quarterCounter + " quarters \n" + dimeCounter + " dimes \n" + nickelCounter + " nickels\n" + BANNER + " UmbrellaCorp does NOT accept liability for ALL side effects including DEATH" + BANNER);
    }
    public void withdraw(int amountToWithdraw) {
            balance = (balance) - (amountToWithdraw);
    }
}












