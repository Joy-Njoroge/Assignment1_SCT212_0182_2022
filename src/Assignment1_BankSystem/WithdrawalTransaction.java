package Assignment1_BankSystem;

import java.util.Calendar;

// Import the InsufficientFundsException class
import Assignment1_BankSystem.InsufficientFundsException;

public class WithdrawalTransaction extends BaseTransaction {

    public WithdrawalTransaction(double amount, Calendar date) {
        super(amount, date);
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be positive.");
        }
    }

    @Override
    public void apply(BankAccount ba) throws InsufficientFundsException {
        if (ba.getBalance() >= getAmount()) {
            ba.setBalance(ba.getBalance() - getAmount());
        } else {
            throw new InsufficientFundsException("Insufficient funds for withdrawal of $" + getAmount());
        }
    }

    @Override
    public void printTransactionDetails() {
        System.out.println("Amount: $" + getAmount());
        System.out.println("Date: " + getDate().getTime());
        System.out.println("Transaction ID: " + getTransactionID());
    }

    // New reverse method to reverse the withdrawal
    public void reverse(BankAccount ba) {
        ba.setBalance(ba.getBalance() + getAmount()); // Add the withdrawn amount back to the balance
        System.out.println("Reversal of withdrawal successful.");
    }
}