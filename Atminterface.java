import java.util.Scanner;

// Class to represent the user's bank account
class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }
}

// Class to represent the ATM machine
public class Atminterface {
    private BankAccount userAccount;

    public Atminterface(BankAccount account) {
        userAccount = account;
    }

    // Method to display the ATM menu
    public void displayMenu() {
        System.out.println("ATM Menu:");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
    }

    // Method to handle withdrawal
    public void withdraw(double amount) {
        if (userAccount.withdraw(amount)) {
            System.out.println("Withdrawal successful. Current balance: $" + userAccount.getBalance());
        } else {
            System.out.println("Insufficient balance. Withdrawal failed.");
        }
    }

    // Method to handle deposit
    public void deposit(double amount) {
        userAccount.deposit(amount);
        System.out.println("Deposit successful. Current balance: $" + userAccount.getBalance());
    }

    // Method to display account balance
    public void checkBalance() {
        System.out.println("Current balance: $" + userAccount.getBalance());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the ATM!");
        System.out.print("Enter initial account balance: $");
        double initialBalance = scanner.nextDouble();

        BankAccount account = new BankAccount(initialBalance);
        Atminterface atm = new Atminterface(account);

        int choice;
        do {
            atm.displayMenu();
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter withdrawal amount: $");
                    double withdrawAmount = scanner.nextDouble();
                    atm.withdraw(withdrawAmount);
                    break;
                case 2:
                    System.out.print("Enter deposit amount: $");
                    double depositAmount = scanner.nextDouble();
                    atm.deposit(depositAmount);
                    break;
                case 3:
                    atm.checkBalance();
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);

        scanner.close();
    }
}
