package Assignment1_BankSystem;

import java.util.Calendar;

public class DepositTransaction extends BaseTransaction {

    /**
     * Constructor for DepositTransaction
     *
     * @param amount transaction amount (positive value expected)
     * @param date   transaction date
     */
    public DepositTransaction(double amount, Calendar date) {
        super((int) amount, date);
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive.");
        }
    }

    /**
     * Apply the deposit to the bank account
     *
     * @param ba BankAccount object
     */
    @Override
    public void apply(BankAccount ba) {
        ba.setBalance(ba.getBalance() + getAmount());
    }

    /**
     * Print deposit transaction details
     */
    @Override
    public void printTransactionDetails() {
        System.out.println("Deposit Transaction:");
        System.out.println("Amount: $" + getAmount());
        System.out.println("Date: " + getDate().getTime());
        System.out.println("Transaction ID: " + getTransactionID());
    }
}
