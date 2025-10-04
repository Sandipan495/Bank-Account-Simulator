import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Account Class
class Account {
    private String accountNumber;
    private String accountHolder;
    private double balance;
    private List<String> transactionHistory;

    // Constructor
    public Account(String accountNumber, String accountHolder, double initialBalance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
        this.transactionHistory = new ArrayList<>();
        transactionHistory.add("Account created with balance: " + initialBalance);
    }

    // Deposit method
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactionHistory.add("Deposited: " + amount + " | Balance: " + balance);
            System.out.println("Successfully deposited " + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Withdraw method
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            transactionHistory.add("Withdrew: " + amount + " | Balance: " + balance);
            System.out.println("Successfully withdrew " + amount);
        } else {
            System.out.println("Insufficient funds or invalid amount.");
        }
    }

    // Get current balance
    public double getBalance() {
        return balance;
    }

    // Print transaction history
    public void printTransactionHistory() {
        System.out.println("\nTransaction History for " + accountHolder + " (" + accountNumber + "):");
        for (String transaction : transactionHistory) {
            System.out.println(transaction);
        }
    }
}

// Main Class
public class BankSimulation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create an account with user input
        System.out.print("Enter Account Number: ");
        String accNumber = scanner.nextLine();

        System.out.print("Enter Account Holder Name: ");
        String accHolder = scanner.nextLine();

        System.out.print("Enter Initial Balance: ");
        double initBalance = scanner.nextDouble();

        Account account = new Account(accNumber, accHolder, initBalance);

        int choice;
        do {
            System.out.println("\n==== Bank Menu ====");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Transaction History");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter deposit amount: ");
                    double dep = scanner.nextDouble();
                    account.deposit(dep);
                    break;

                case 2:
                    System.out.print("Enter withdrawal amount: ");
                    double wd = scanner.nextDouble();
                    account.withdraw(wd);
                    break;

                case 3:
                    System.out.println("Current Balance: " + account.getBalance());
                    break;

                case 4:
                    account.printTransactionHistory();
                    break;

                case 5:
                    System.out.println("Exiting... Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 5);

        scanner.close();
    }
}
