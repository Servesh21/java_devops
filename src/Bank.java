/*Write a Menu driven program in java to implement
simple banking application. Application should read
the customer name, account number, initial balance,
rate of interest, contact number and address field etc.
Application should have following methods.
1. createAccount()
2. deposit()
3. withdraw()
4. computeInterest()
5. displayBalance()*/


import java.util.Scanner;

class Customer {
    String name;
    int accountno;
    String address;
    String contactno;
    double balance;
    double interest;

    // Method to create a new account
    void createAccount() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Name: ");
        name = sc.nextLine();
        System.out.print("Enter Account No: ");
        accountno = sc.nextInt();
        sc.nextLine();// Consume newline left-over from nextInt()
        System.out.print("Enter Address: ");
        address = sc.nextLine();
        System.out.print("Enter Contact No: ");
        contactno = sc.nextLine();
        check(contactno);  // Validate the contact number
        System.out.print("Enter Balance: ");
        balance = sc.nextDouble();
        System.out.print("Enter Interest: ");
        interest = sc.nextDouble();
    }

    // Method to validate the contact number
    void check(String no) {
        if (no.length() != 10) {  // Check if the contact number is 10 digits
            System.out.println("Contact number is not 10 digits");
            System.out.println("Enter Contact No again");
            Scanner sc = new Scanner(System.in);
            contactno = sc.nextLine();
            check(contactno);  // Recursively validate the new contact number
        }
    }



    // Method to deposit an amount into the account
    void deposit() {
        System.out.println("Enter the Amount to be Deposited");
        Scanner sc = new Scanner(System.in);
        int amt = sc.nextInt();
        sc.nextLine();  // Consume newline left-over from nextInt()
        balance += amt;  // Add the deposit amount to the balance
        System.out.println("Amount Deposited: " + amt);
    }

    // Method to withdraw an amount from the account
    void withdraw() {
        System.out.println("Enter the Amount to be Withdrawn");
        Scanner sc = new Scanner(System.in);
        int amt = sc.nextInt();
        sc.nextLine();  // Consume newline left-over from nextInt()
        if (amt > balance) {  // Check if there's enough balance
            System.out.println("Insufficient balance!");
        } else {
            balance -= amt;  // Deduct the withdrawal amount from the balance
            System.out.println("Amount Withdrawn: " + amt);
        }
    }

    // Method to compute and add interest to the balance
    void computeInterest() {
        System.out.println("Computing Interest...");
        balance = balance * 0.01 * interest + balance;  // Calculate new balance with interest
        System.out.println("New Balance after interest: " + balance);
    }

    // Method to display the current balance
    void displayBalance() {
        System.out.println("Balance: " + balance);
    }
}

public class Bank {
    public static void main(String[] args) {
        int a = -1;  // Index for customer array
        Scanner sc = new Scanner(System.in);
        Customer[] cust = new Customer[10];

        while (true) {
            // Display menu options
            System.out.println("1. Create Account \n2. Deposit \n3. Withdraw \n4. Calculate Interest \n5. Display Balance \n6. Exit");
            String choice = sc.nextLine();

            switch (choice) {
                case "1": {
                    a++;  // Increment customer index
                    cust[a] = new Customer();  // Create a new customer object
                    cust[a].createAccount();  // Call method to create a new account
                    break;
                }
                case "2": {
                    if (a == -1) {  // Check if there are no accounts
                        System.out.println("No Account Details Available");
                    } else {
                        System.out.print("Enter Account No: ");
                        int num = sc.nextInt();
                        sc.nextLine();  // Consume newline left-over from nextInt()
                        int i;
                        for (i = 0; i <= a; i++) {  // Search for the account by number
                            if (num == cust[i].accountno) {
                                cust[i].deposit();  // Call method to deposit money
                                break;
                            }
                        }
                        if (i > a) {
                            System.out.println("No Account found");
                        }
                    }
                    break;
                }
                case "3": {
                    if (a == -1) {  // Check if there are no accounts
                        System.out.println("No Account Details Available");
                    } else {
                        System.out.print("Enter Account No: ");
                        int num = sc.nextInt();
                        sc.nextLine();  // Consume newline left-over from nextInt()
                        int i;
                        for (i = 0; i <= a; i++) {  // Search for the account by number
                            if (num == cust[i].accountno) {
                                cust[i].withdraw();  // Call method to withdraw money
                                break;
                            }
                        }
                        if (i > a) {
                            System.out.println("No Account found");
                        }
                    }
                    break;
                }
                case "4": {
                    if (a == -1) {  // Check if there are no accounts
                        System.out.println("No Account Details Available");
                    } else {
                        System.out.print("Enter Account No: ");
                        int num = sc.nextInt();
                        sc.nextLine();  // Consume newline left-over from nextInt()
                        int i;
                        for (i = 0; i <= a; i++) {  // Search for the account by number
                            if (num == cust[i].accountno) {
                                cust[i].computeInterest();  // Call method to compute interest
                                break;
                            }
                        }
                        if (i > a) {
                            System.out.println("No Account found");
                        }
                    }
                    break;
                }
                case "5": {
                    if (a == -1) {  // Check if there are no accounts
                        System.out.println("No Account Details Available");
                    } else {
                        System.out.print("Enter Account No: ");
                        int num = sc.nextInt();
                        sc.nextLine();  // Consume newline left-over from nextInt()
                        int i;
                        for (i = 0; i <= a; i++) {  // Search for the account by number
                            if (num == cust[i].accountno) {
                                cust[i].displayBalance();  // Call method to display balance
                                break;
                            }
                        }
                        if (i > a) {
                            System.out.println("No Account found");
                        }
                    }
                    break;
                }
                case "6": {
                    System.exit(0);  // Exit the program
                }
                default:
                    System.out.println("Invalid Choice");  // Handle invalid input
            }
        }
    }
}
