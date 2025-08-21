/*
1) Implement a java program to calculate gross salary &
        net salary taking the following data.
        Input: empno, empname, basic
        Process:
        DA=70% of basic
        HRA=30% of basic
        CCA=Rs240/-
        PF=10% of basic
        PT= Rs100/- */


import java.util.Scanner; // Importing Scanner class for input

// Class to represent an Employee
class Emp {
    int empno; // Variable to store Employee Number
    String empname; // Variable to store Employee Name
    int basic; // Variable to store Basic salary
    int max = 10; // Maximum number of employees
    double gross; // Variable to store Gross salary
    double net; // Variable to store Net salary

    /* Constructor to initialize employee details */
    Emp(int no, String name, int basic1) {
        empno = no;
        empname = name;
        basic = basic1;
        calculateSalaries(); // Calculate salaries on initialization
    }

    /* Method to calculate Gross and Net salary */
    void calculateSalaries() {
        double DA = 0.70 * basic; // Dearness Allowance
        double HRA = 0.30 * basic; // House Rent Allowance
        int CCA = 240; // City Compensatory Allowance
        double PF = 0.10 * basic; // Provident Fund
        int PT = 100; // Professional Tax
        gross = basic + DA + HRA + CCA; // Calculating Gross Salary
        net = gross - PF - PT; // Calculating Net Salary
    }

    /* Method to edit employee details */
    void Edit() {
        System.out.println("1. Name \n2. Basic Salary \n3. Employee No");
        Scanner sc = new Scanner(System.in);
        String choice = sc.nextLine();

        // Switch case to handle different edit options
        switch (choice) {
            case "1": // Edit Name
                System.out.println("Enter the new name: ");
                empname = sc.next();
                System.out.println("Employee Name Updated");
                break;

            case "2": // Edit Basic Salary
                System.out.println("Enter the new basic salary: ");
                basic = sc.nextInt();
                System.out.println("Basic salary Updated");
                calculateSalaries(); // Recalculate salaries after update
                sc.nextLine(); // Consume the newline character
                break;

            case "3": // Edit Employee Number
                System.out.println("Enter the new Employee No: ");
                int no = sc.nextInt();
                int i;
                for (i = 0; i < max; i++) {
                    if (no == empno) {
                        System.out.println("Existing Employee No cannot be used");
                    }
                }
                if (i == max) {
                    empno = no;
                    System.out.println("Employee No Updated");
                }
                sc.nextLine(); // Consume the newline character
                break;

            default:
                System.out.println("Invalid choice");
        }
        System.out.println(); // Adding a newline for better readability
    }

    /* Method to display employee details */
    void display() {
        System.out.println("Employee No: " + empno);
        System.out.println("Name: " + empname);
        System.out.println("Gross Salary: " + gross);
        System.out.println("Net Salary: " + net);
        System.out.println(); // Adding a newline for better readability
    }
} // End of Emp class

public class Employee {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Emp[] emp1 = new Emp[10]; // Array to store employee objects
        int max = 10; // Maximum number of employees
        int i;

        /* Input Data for all Employees */
        for (i = 0; i < max; i++) {
            System.out.print("Enter employee no: ");
            int no = sc.nextInt();

            // Check if the employee number already exists
            for (int j = 0; j < i; j++) {
                if (no == emp1[j].empno) {
                    System.out.println("Employee number " + emp1[j].empno + " is not available. Enter again");
                    int no1 = sc.nextInt();
                    no = no1;
                }
            }

            System.out.print("Enter employee name: ");
            String name = sc.next();

            System.out.print("Enter basic pay: ");
            int basic = sc.nextInt();
            sc.nextLine(); // Consume the newline character

            emp1[i] = new Emp(no, name, basic); // Create a new employee object
        }

        while (true) {  // Infinite loop to keep the program running
            System.out.println("1. Edit \n2. Display \n3. Exit");
            String choice = sc.nextLine();

            switch (choice) {
                case "1": {
                    System.out.print("Enter employee no whose details are to be edited: ");
                    int no = sc.nextInt();
                    sc.nextLine(); // Consume the newline character

                    for (i = 0; i < max; i++) {
                        if (emp1[i].empno == no) {
                            emp1[i].Edit();
                            break;
                        }
                    }
                    if (i == max) {
                        System.out.println("Employee Not Found");
                    }
                    break;
                }

                case "2": {
                    System.out.print("1. Display data of all Employees \n2. Display data of a single employee \n");
                    String choice1 = sc.nextLine();

                    switch (choice1) {
                        case "1":
                            for (i = 0; i < max; i++) {
                                emp1[i].display();
                            }
                            break;

                        case "2":
                            System.out.print("Enter employee no whose data is to be displayed: ");
                            int no2 = sc.nextInt();
                            sc.nextLine(); // Consume the newline character

                            for (i = 0; i < max; i++) {
                                if (no2 == emp1[i].empno) {
                                    emp1[i].display();
                                    break;
                                }
                            }
                            if (i == max) {
                                System.out.println("Employee Not Found");
                            }
                            break;
                    }
                    break;
                }

                case "3": // Exit the program
                    System.exit(0);

                default:
                    System.out.println("Wrong input");
                    System.out.println(); // Adding a newline for better readability
                    break;
            }
        }
    }
} // End of Employee class
