package Assignment1_BankSystem;

import java.util.Calendar;


public class Main {
    public static void main(String[] args) {
        Calendar date = Calendar.getInstance();

        BankAccount account = new BankAccount(500.0);  // Initialize account with a balance of $500
        WithdrawalTransaction withdrawal = new WithdrawalTransaction(100.0, date);

        System.out.println("Initial Balance: $" + account.getBalance());

        // Apply Withdrawal
        try {
            withdrawal.apply(account);
            System.out.println("Balance after withdrawal: $" + account.getBalance());
        } catch (InsufficientFundsException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Test Reversal
        withdrawal.reverse(account);
        System.out.println("Balance after reversal: $" + account.getBalance());

        // Test Insufficient Funds Withdrawal
        WithdrawalTransaction largeWithdrawal = new WithdrawalTransaction(1000.0, date);
        try {
            largeWithdrawal.apply(account);
        } catch (InsufficientFundsException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}