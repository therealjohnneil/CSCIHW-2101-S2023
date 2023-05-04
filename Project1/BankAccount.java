package Project1;

import java.util.Scanner;
/*
 * Appas Bank
 * Bank Account Parameters:
 * public Name -> String ✓
 * private Balance -> double ✓ 
 * private Date of Birth -> String ✓
 * private SSN -> int (Maybe String) ✓
 * private Account Number -> int ✓
 * 
 * Bank Account Methods:
 * Constructor 
 * Getters and Setters
 * Deposit
 * Withdraw
 * Transfer (HomeWork)
 * Balance
 * Menu
 * Compound Interest
 * Simple Interest (HomeWork)
 * Authentication Basic
 * Authentication Advanced (HomeWork?)
 * 
 * Bank Account Constructor
 * Name, Balance, SSN, Account Number, Date of Birth
 * Name, SSN
 */

public class BankAccount {

    // Bank Account Parameters
    public String name;
    private double balance;
    private String dob;
    private int ssn;
    private int accountNumber;
    public double interestRate = 0.01;
    public int period = 4; // quarterly

    // Bank Account Constructor
    public BankAccount(String name, int ssn, double balance, int accountNumber, String dob) {
        this.name = name;
        this.ssn = ssn;
        this.balance = balance;
        this.accountNumber = accountNumber;
        this.dob = dob;
    }

    // Bank Account Constructor
    public BankAccount(String name, int ssn) {
        this.name = name;
        this.ssn = ssn;
    }

    // Bank Account Methods

    // Note you do need to create a getter for public variables however it is best
    // practice to create a getter for all variables

    /*
     * Getters and Setters
     */

    public String getName() {
        return this.name;
    }

    public double getbalance() {
        return this.balance;
    }

    public String getdob() {
        return this.dob;
    }

    public int getssn() {
        return this.ssn;
    }

    public int getaccountNumber() {
        return this.accountNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    /*
     * Should only be used by during the creation of the account never after instead
     * see deposit and withdraw
     */
    public void setbalance(double balance) {
        this.balance = balance;
    }

    public void setdob(String dob) {
        this.dob = dob;
    }

    public void setssn(int ssn) {
        this.ssn = ssn;
    }

    public void setaccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }

    public void withdraw(double amount) {
        this.balance -= amount;
        if (amount <= this.balance) {
            System.out.println("You have withdrawn $" + amount);
            System.out.println("Your new balance is: $" + balance);
        } else {
            this.balance += amount;
            overdraft(amount);
        }
    }

    // Create a mthod that will subtract a mothly fee from the balance
    // this method will take a double as a parameter
    // this method will subtract the fee from the balance
    // Netflix subscription is $12.99
    public void monthlyFee(double fee) {
        withdraw(fee);
    }

    // Create a method that will print a menu to the user
    // This is called a helper method / function
    public static int menu() {
        int choice;
        Scanner input = new java.util.Scanner(System.in);
        System.out.println("Welcome to Appas Bank");
        System.out.println("1. Deposit");
        System.out.println("2. Withdraw");
        System.out.println("3. Transfer"); // HomeWork
        System.out.println("4. Balance");
        System.out.println("5. Compound Interest");
        System.out.println("6. Simple Interest"); // HomeWork
        System.out.println("7. Create Savings Account"); // HomeWork
        System.out.println("0. Exit");
        System.out.println("Please enter your choice: ");
        choice = input.nextInt();
        return choice;
    }

    public void printBalance() {
        System.out.println("Your balance is: $" + this.balance);
    }

    // Create a method that will interact with the user based on their choice from
    // the menu method
    // This method will take a Bank Account as a parameter
    public static void interact(BankAccount account, BankAccount account2) {
        // get the choice from the menu method
        int choice = menu();
        // create a scanner object
        Scanner input = new java.util.Scanner(System.in);
        // use that choice and run the method associated with that choice

        if (choice == 1) {
            System.out.println("Please enter the amount you would like to deposit: ");
            double amount = input.nextDouble();
            account.deposit(amount);
            account.printBalance();

        } else if (choice == 2) {
            System.out.println("Please enter the amount you would like to withdraw: ");
            double amount = input.nextDouble();
            if (amount <= account.getbalance()) {
                account.withdraw(amount); }

        } else if (choice == 3) {
        System.out.println("How much would you like to transfer?");
        double transferAmount = input.nextDouble();
        System.out.println("Which account would you like to transfer from?");
        System.out.println("1. " + account.name);
        System.out.println("2. " + account2.name);
        transfer(account, account2, transferAmount);
             // place holder for choice 3
        
        } else if (choice == 4) {
            account.printBalance();

        } else if (choice == 5) {
            System.out.println("How many years? (Whole numbers only)");
            int years = input.nextInt();
            account.compoundInterest(account.getbalance(), years, account.interestRate, account.period);
            account.printBalance();

        } else if (choice == 6) {
            System.out.println("How many years? (Whole numbers only)");
            int years = input.nextInt();
            account.simpleInterest(account.getbalance(), years, account.interestRate);
            account.printBalance();
            // place holder for choice 6
            
        } else if (choice == 7) {
            account.createSavingsAccount(input);
            // place holder for choice 7

        } else if (choice == 0) {
            System.out.println("Thank you for banking with Appas Bank");

        } else { // this would catch any invalid choices like
            System.out.println("Invalid choice");
        }

    }

    // Go back to main menu method
public void backToMainMenu() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Back to Main Menu (Y/N)");
            String answer = scanner.next();
            if (answer.equalsIgnoreCase("Y")) {
                interact(this, this);
            } else if (answer.equalsIgnoreCase("N")) {
                System.out.println("Thank you for banking with Appas Bank");
            } else {
                System.out.println("Invalid choice");
            }
}
    // Create a method that will calculate the interest on the balance using
    // compound interest
    // P(1 + R/n)^(nt) - P
    // A = P(1 + R/n)^(nt)
    // P = Principal
    // R = Rate
    // n = number of times interest is compounded per year (annum)
    // t = number of years
    // This method will take a double as an argument
    // This method will return a double

    // P can be this.balance or getBalance() if you would like to use a getter
    public void compoundInterest(double principal, int time, double rate, int annum) {
        double amount = principal * Math.pow(1 + (rate / annum), annum * time);
        double roundedAmount = Math.round(amount * 100.0) / 100.0;
        double compinterest = amount - principal; // A-P
        compinterest = Math.round(compinterest * 100.0) / 100;

        System.out.println("Current Rate is: " + rate + "%");
        System.out.println("Current Period is: " + annum + " times per year");
        System.out.println("Selected Time is: " + time + " years");
        System.out.println("Compound Interest after " + time + " years is: $" + compinterest);
        System.out.println("Total Amount after " + time + " years is: $" + roundedAmount);
    }

    // Overdraft Method
    public void overdraft(double amount) {
        if (this.balance - amount <= 0) {
            System.out.println("You do not have enough funds to withdraw $" + amount);
            System.out.println("If you continue you will be charged a $35 overdraft fee");
            System.out.println("Would you like to continue?");
            System.out.println("1. Yes");
            System.out.println("2. No");
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            if (choice == 1) {
                this.balance -= amount;
                this.balance -= 35;
                System.out.println("You have been charged a $35 overdraft fee");
                System.out.println("Your new balance is: $" + this.balance);
                backToMainMenu();
            } else if (choice == 2) {
                System.out.println("Transaction Cancelled");
                backToMainMenu();
                }
            }
            
            else {
                System.out.println("Invalid choice");
                backToMainMenu();
            }
    }
    // Transfer Method
    public static void transfer(BankAccount account, BankAccount account2, double amount) {
        try (Scanner scanner = new Scanner(System.in)) {
            int choice = scanner.nextInt();
            if (choice == 1) {
                account.withdraw(amount);
                account2.deposit(amount);
                System.out.println("You have transferred $" + amount + " to " + account2.name);
                System.out.println("Your new balance is: $" + account.getbalance());
            } else if (choice == 2) {
                account2.withdraw(amount);
                account.deposit(amount);
                System.out.println("You have transferred $" + amount + " to " + account.name);
                System.out.println("Your new balance is: $" + account2.getbalance());
            } else {
                System.out.println("Invalid choice");
            }
        }
    }
    // Simple Interest Method
    public void simpleInterest(double principal, int time, double rate) {
        double amount = principal * (1 + (rate * time));
        double roundedAmount = Math.round(amount * 100.0) / 100.0;
        double simpinterest = amount - principal; // A-P
        simpinterest = Math.round(simpinterest * 100.0) / 100;

        System.out.println("Current Rate is: " + rate + "%");
        System.out.println("Selected Time is: " + time + " years");
        System.out.println("Simple Interest after " + time + " years is: $" + simpinterest);
        System.out.println("Total Amount after " + time + " years is: $" + roundedAmount);
    }

    // CreateSavingsAccount Method
    public void createSavingsAccount(Scanner input) {
        if (this.balance >= 10000) {
            System.out.println("You have enough funds to create a savings account");
            System.out.println("Would you like to create a savings account?");
            System.out.println("1. Yes");
            System.out.println("2. No");
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            if (choice == 1) {
                System.out.println("What is the initial deposit?");
                double initialDeposit = input.nextDouble();
                System.out.println("What is the time?");
                int time = input.nextInt();
                System.out.println("Would you like to use compound interest or simple interest on your savings?");
                System.out.println("1. Compound Interest");
                System.out.println("2. Simple Interest");
                int select = input.nextInt();
                        if (select == 1) {
                            System.out.println("How many years?");
                            int years = input.nextInt();
                            compoundInterest(initialDeposit, time, 0.0001, 4);
                        }else if (select == 2) {
                            System.out.println("How many years?");
                            int years = input.nextInt();
                            simpleInterest(initialDeposit, time, 0.001);
                        }else {
                            System.out.println("Invalid choice");
                        }
        } else {
            System.out.println("You do not have enough funds to create a savings account");
            System.out.println("You need at least $10,000 to create a savings account");
            System.out.println("Your current balance is: $" + this.balance);
            System.out.println("Thank you for banking with Appas Bank");

        
    }


}
}
}