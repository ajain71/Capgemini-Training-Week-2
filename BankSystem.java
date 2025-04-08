import java.util.ArrayList;
class Bank {
    public String bankName;
    private ArrayList<Account> accounts;
    public Bank(String bankName) {
        this.bankName = bankName;
        this.accounts = new ArrayList<>();
    }
    public Account openAccount(Customer customer, double initialDeposit) {
        Account newAccount = new Account(this, customer, initialDeposit);
        accounts.add(newAccount);
        customer.addAccount(newAccount);
        System.out.println("Account opened for " + customer.getName() + " at " + bankName + " with initial deposit: $" + initialDeposit);
        return newAccount;
    }
    public void displayBankInfo() {
        System.out.println("Bank: " + bankName);
        System.out.println("Accounts in this bank:");
        for (Account account : accounts) {
            System.out.println("- " + account.getCustomer().getName() + " | Balance: $" + account.getBalance());
        }
        System.out.println();
    }
}
class Customer {
    private String name;
    private int customerId;
    private ArrayList<Account> accounts;
    public Customer(String name, int customerId) {
        this.name = name;
        this.customerId = customerId;
        this.accounts = new ArrayList<>();
    }
    public String getName() {
        return name;
    }
    public void addAccount(Account account) {
        accounts.add(account);
    }
    public void viewBalance() {
        System.out.println("Customer: " + name);
        System.out.println("Bank Accounts:");
        for (Account account : accounts) {
            System.out.println("- Bank: " + account.getBank().bankName + " | Balance: $" + account.getBalance());
        }
        System.out.println();
    }
}
class Account {
    private Bank bank;
    private Customer customer;
    private double balance;
    public Account(Bank bank, Customer customer, double initialDeposit) {
        this.bank = bank;
        this.customer = customer;
        this.balance = initialDeposit;
    }
    public Bank getBank() {
        return bank;
    }
    public Customer getCustomer() {
        return customer;
    }
    public double getBalance() {
        return balance;
    }
}
public class BankSystem {
    public static void main(String[] args) {
        Bank bank1 = new Bank("State Bank");
        Bank bank2 = new Bank("National Bank");
        Customer customer1 = new Customer("Alice Johnson", 101);
        Customer customer2 = new Customer("Bob Williams", 102);
        bank1.openAccount(customer1, 1000);
        bank1.openAccount(customer2, 1500);
        bank2.openAccount(customer1, 2000);
        customer1.viewBalance();
        customer2.viewBalance();
        bank1.displayBankInfo();
        bank2.displayBankInfo();
    }
}