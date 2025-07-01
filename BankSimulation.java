import java.util.ArrayList;
import java.util.Scanner;

class Account {
    private String accountHolder;
    private int accountNumber;
    private double balance;
    private ArrayList<String> transactionHistory;

    public Account(String accountHolder, int accountNumber) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = 0.0;
        this.transactionHistory = new ArrayList<>();
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit amount :" + amount);
            System.out.println("Amount deposit Successfully.");
        } else {
            System.out.println("Please Enter valid amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount >= 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Amount :" + amount + "Withdraw successfully.");
        } else {
            System.out.println("Insuficient Balance or Invalid amount.");
        }
    }

    public void viewBlanace() {
        System.out.println("Current Balance :" + balance);
    }

    public void showHistory() {
        System.out.println("Transaction History :");
        for (String transaction : transactionHistory) {
            System.out.println("Tracnsaction : " + transaction);
        }
    }
}
public class BankSimulation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean exit = true;

        System.out.print("Enter the account holder name :");
        String name = sc.nextLine();
        System.out.print("Enter the account number :");
        int acnum = sc.nextInt(); 

        Account account = new Account(name, acnum);

        while(exit){
            System.out.println("Choose an operation");
            System.out.println("1. Deposit");
            System.out.println("2. Withdrawl");
            System.out.println("3. Check balance");
            System.out.println("4. Check Transaction History");
            System.out.println("5. Exit");

            int choose = sc.nextInt();

            if(choose == 5){
                exit = false;
                System.out.println("You are exit from System.");
                break; 
            }

            switch(choose){
                case 1 :
                    System.out.print("Enter the amount you want to deposit :");
                    double depamount = sc.nextDouble();
                    account.deposit(depamount);
                    break;
                case 2 :
                    System.out.print("Enter the amoount you want to withdrawal :");
                    double withamount = sc.nextDouble();
                    account.deposit(withamount);
                    break;
                case 3 :
                    account.viewBlanace();
                    break;
                case 4 :
                    account.showHistory();
                    break;
                default :
                System.out.println("Invalid choice");
                continue;
            }
        }
    }
}
