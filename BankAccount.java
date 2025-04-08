 import java.util.Scanner;

class BankAccount {
    private static String bankName = "XYZ Bank";
    private static int totalAccounts = 0;
    private final String accountNumber;
    private String accountHolderName;
    private double balance;

    // Constructor
    public BankAccount(String accountHolderName, String accountNumber, double balance) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        this.balance = balance;
        totalAccounts++;
    }

    // Method to display account details
    public void displayAccountDetails() {
        if (this instanceof BankAccount) {
            System.out.println("Bank Name: " + bankName);
            System.out.println("Account Holder: " + accountHolderName);
            System.out.println("Account Number: " + accountNumber);
            System.out.println("Balance: $" + balance);
        }
    }

    // Static method to get total accounts
    public static void getTotalAccounts() {
        System.out.println("Total Accounts Created: " + totalAccounts);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Creating bank accounts
        BankAccount acc1 = new BankAccount("Alice Johnson", "123456789", 5000.00);
        BankAccount acc2 = new BankAccount("Bob Smith", "987654321", 7000.00);
        
        // Display account details
        acc1.displayAccountDetails();
        acc2.displayAccountDetails();
        
        // Display total accounts created
        BankAccount.getTotalAccounts();
        
        scanner.close();
    }
}

