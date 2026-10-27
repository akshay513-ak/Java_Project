import java.util.*;

class BankAccount {
    private String accountHolderName;
    private long accountNumber;
    private double balance;

    // Constructor
    public BankAccount(String name, long accNo) {
        accountHolderName = name;
        accountNumber = accNo;
        balance = 0.0;
    }

    // Deposit method
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Amount deposited successfully.");
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Withdraw method
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Amount withdrawn successfully.");
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    // Check balance
    public void checkBalance() {
        System.out.println("Current Balance: ₹" + balance);
    }

    // Display account details
    public void displayDetails() {
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Account Number: " + accountNumber);
    }
}

public class BankAccountSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Bank Account Registration ===");
        System.out.print("Enter Account Holder Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Account Number: ");
        long accNo = sc.nextLong();

        BankAccount account = new BankAccount(name, accNo);

        int choice;
        do {
            System.out.println("\n--- Bank Menu ---");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Account Details");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter deposit amount: ");
                    double depAmount = sc.nextDouble();
                    account.deposit(depAmount);
                    break;

                case 2:
                    System.out.print("Enter withdrawal amount: ");
                    double withAmount = sc.nextDouble();
                    account.withdraw(withAmount);
                    break;

                case 3:
                    account.checkBalance();
                    break;

                case 4:
                    account.displayDetails();
                    break;

                case 5:
                    System.out.println("Thank you for using the bank system.");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 5);

        sc.close();
    }
}
