class BankAccount {
    protected String accountNumber;
    protected double balance;
    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }
    public void displayBalance() {
        System.out.println("Account Number: " + accountNumber + ", Balance: $" + balance);
    }
    public void displayAccountType() {
        System.out.println("General Bank Account");
    }
}
class SavingsAccount extends BankAccount {
    private double interestRate;
    public SavingsAccount(String accountNumber, double balance, double interestRate) {
        super(accountNumber, balance);
        this.interestRate = interestRate;
    }
    @Override
    public void displayAccountType() {
        System.out.println("Savings Account");
    }
    public void displayInterestRate() {
        System.out.println("Interest Rate: " + interestRate + "%");
    }
}
class CheckingAccount extends BankAccount {
    private double withdrawalLimit;
    public CheckingAccount(String accountNumber, double balance, double withdrawalLimit) {
        super(accountNumber, balance);
        this.withdrawalLimit = withdrawalLimit;
    }
    @Override
    public void displayAccountType() {
        System.out.println("Checking Account");
    }
    public void displayWithdrawalLimit() {
        System.out.println("Withdrawal Limit: $" + withdrawalLimit + " per transaction");
    }
}
class FixedDepositAccount extends BankAccount {
    private int lockInPeriod;
    public FixedDepositAccount(String accountNumber, double balance, int lockInPeriod) {
        super(accountNumber, balance);
        this.lockInPeriod = lockInPeriod;
    }
    @Override
    public void displayAccountType() {
        System.out.println("Fixed Deposit Account");
    }
    public void displayLockInPeriod() {
        System.out.println("Lock-in Period: " + lockInPeriod + " months");
    }
}
public class BankingSystem {
    public static void main(String[] args) {
        SavingsAccount savings = new SavingsAccount("SA12345", 5000, 4.5);
        savings.displayAccountType();
        savings.displayBalance();
        savings.displayInterestRate();
        System.out.println();
        CheckingAccount checking = new CheckingAccount("CA98765", 2000, 1000);
        checking.displayAccountType();
        checking.displayBalance();
        checking.displayWithdrawalLimit();
        System.out.println();
        FixedDepositAccount fixedDeposit = new FixedDepositAccount("FD56789", 10000, 12);
        fixedDeposit.displayAccountType();
        fixedDeposit.displayBalance();
        fixedDeposit.displayLockInPeriod();
    }
}