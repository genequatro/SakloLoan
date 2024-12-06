package SakloLoan;

import java.util.Scanner;

public class Main {

    private static Scanner input = new Scanner(System.in);
    private static User currentUser;
    private static Loan currentLoan;
    private static PayLoan currentPayLoan;

    public static void main(String[] args) {
        while (true) {
            userMenu();

            boolean exit = false;
            while (!exit) {
                displayMenu();
                System.out.print("Select your transaction: ");
                int transaction = input.nextInt();
                System.out.println();

                switch (transaction) {
                    case 1:
                        currentLoan = new ApplyLoan(currentUser).applyLoan();
                        if (currentLoan != null) {
                            currentPayLoan = new PayLoan(currentLoan);
                        }
                        break;
                    case 2:
                        if (currentLoan == null) {
                            System.out.println("Please apply for a loan first.\n");
                            break;
                        }
                        currentPayLoan.displayMenu();
                        break;
                    case 3:
                        if (currentLoan == null) {
                            System.out.println("No loan information available.\n");
                        } else {
                            LoanStatus loanStatus = new LoanStatus(currentLoan);
                            loanStatus.displayLoanStatus();
                        }
                        break;
                    case 4:
                        LoanCalculator loanCalculator = new LoanCalculator(currentUser);
                        loanCalculator.calculate();
                        break;
                    case 5:
                        exit = true;
                        break;
                    default:
                        System.out.println("Invalid transaction selected. Please try again.\n");
                }
            }
        }
    }

    
    static void displayMenu() {
        System.out.println("O======================================================O");
        System.out.println("\t\t\tMENU\t\t       ");
        System.out.println("O======================================================O");
        System.out.println("\t1. Apply for Loan\t 3. Loan Status");
        System.out.println("\t2. Pay Loan\t\t 4. Loan Calculator");
        System.out.println("       \t\t5. Exit to Main Menu");
        System.out.println("O======================================================O");
    }

    static void userMenu() {
        System.out.println("O======================================================O");
        System.out.println("\t\t   Welcome to SakloLoan\t\t       ");
        System.out.println("O======================================================O");
        System.out.println("\t\tSelect 1 to Register a user\t       ");
        System.out.println("\t\tSelect 2 to Exit\t\t       ");
        System.out.println("O======================================================O");
        System.out.print("Enter your choice: ");
        int optionSelected = input.nextInt();
        input.nextLine();

        switch (optionSelected) {
            case 1:
                registerUser();
                break;
            case 2:
                System.out.println("O======================================================O");
                System.out.println("\t\tThank you for using SakloLoan.");
                System.out.println("O======================================================O");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice, please try again.\n");
        }
    }

    static void registerUser() {
        System.out.println("O======================================================O");
        System.out.println("\t\t\tREGISTER\t\t       ");
        System.out.println("O======================================================O");
        System.out.print("Enter your full name: ");
        String name = input.nextLine();
        System.out.print("Enter your address:  ");
        String address = input.nextLine();
        System.out.print("Enter your age: ");
        int age = input.nextInt();
        input.nextLine();
        System.out.print("Enter your date of birth (MM/DD/YYYY): ");
        String birthday = input.nextLine();
        System.out.print("Enter your phone number: ");
        String number = input.nextLine();
        System.out.println();
        System.out.print("Enter your monthly income: ");
        double income = input.nextDouble();
        System.out.println();

        currentUser = new User(name, address, age, birthday, number, income);
        System.out.println("O======================================================O");
        System.out.println("\t\tWelcome, " + currentUser.getName() + "!");
        System.out.println("O======================================================O\n");
    }
}
