package Assignment1_BankSystem;

import org.jetbrains.annotations.NotNull;

import java.util.Calendar;

public abstract class BaseTransaction implements TransactionInterface {
    private final double amount; // Changed to double
    private final Calendar date;
    private final String transactionID;

    /**
     * BaseTransaction Constructor
     * @param amount in double
     * @param date: Not null, and must be a Calendar object
     */
    public BaseTransaction(double amount, @NotNull Calendar date)  {  // Changed parameter type to double
        this.amount = amount;
        this.date = (Calendar) date.clone();
        int uniq = (int) (Math.random() * 10000);
        transactionID = date.toString() + uniq;
    }

    public double getAmount() {
        return amount;
    }

    public Calendar getDate() {
        return (Calendar) date.clone();
    }

    public String getTransactionID() {
        return transactionID;
    }

    public abstract void printTransactionDetails();
    public abstract void apply(BankAccount ba) throws InsufficientFundsException;
}
