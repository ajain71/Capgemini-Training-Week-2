
// Interface Loanable
interface Loanable {
    void applyForLoan(double amount);
    boolean calculateLoanEligibility();
}

// Abstract BankAccount class
abstract class BankAccount {
    private String accountNumber;
    private String holderName;
    private double balance;

    // Constructor
    public BankAccount(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    // Encapsulated Getters and Setters
    public String getAccountNumber() {
        return accountNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public double getBalance() {
        return balance;
    }

    protected void setBalance(double balance) {
        this.balance = balance;
    }

    // Concrete Methods
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println(holderName + " deposited $" + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println(holderName + " withdrew $" + amount);
        } else {
            System.out.println("Insufficient balance for withdrawal.");
        }
    }

    // Abstract Method
    public abstract double calculateInterest();

    // Display Details
    public void displayAccountDetails() {
        System.out.println("Account Holder: " + holderName);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Current Balance: $" + balance);
        System.out.println("Interest Earned: $" + calculateInterest());

        if (this instanceof Loanable) {
            boolean eligible = ((Loanable) this).calculateLoanEligibility();
            System.out.println("Loan Eligibility: " + (eligible ? "Eligible" : "Not Eligible"));
        }

        System.out.println("-----------------------------------");
    }
}

// SavingsAccount class
class SavingsAccount extends BankAccount implements Loanable {
    public SavingsAccount(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }

    @Override
    public double calculateInterest() {
        return getBalance() * 0.04; // 4% interest
    }

    @Override
    public void applyForLoan(double amount) {
        System.out.println(getHolderName() + " applied for a personal loan of $" + amount);
    }

    @Override
    public boolean calculateLoanEligibility() {
        return getBalance() >= 5000;
    }
}

// CurrentAccount class
class CurrentAccount extends BankAccount {
    public CurrentAccount(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }

    @Override
    public double calculateInterest() {
        return getBalance() * 0.02; // 2% interest
    }

    // No loan support for current accounts
}

// Main class to test system
public class BankingSystem {
    public static void main(String[] args) {
        BankAccount acc1 = new SavingsAccount("SB101", "Alice", 8000);
        BankAccount acc2 = new CurrentAccount("CA202", "Bob", 12000);
        BankAccount acc3 = new SavingsAccount("SB303", "Charlie", 4000);

        BankAccount[] accounts = { acc1, acc2, acc3 };

        for (BankAccount account : accounts) {
            account.deposit(1000);
            account.withdraw(2000);
            account.displayAccountDetails();
        }

        // Optional: Apply for loan using type cast if eligible
        for (BankAccount account : accounts) {
            if (account instanceof Loanable) {
                ((Loanable) account).applyForLoan(10000);
            }
        }
    }
}

