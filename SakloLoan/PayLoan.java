package SakloLoan;

import java.util.Scanner;

public class PayLoan {

    private Loan loan;
    Scanner input = new Scanner(System.in);

    public PayLoan(Loan loan) {
        this.loan = loan;
    }

    public void displayMenu() {
        System.out.println("O======================================================O");
        System.out.println("\t\t\tPAY LOAN");
        System.out.println("O======================================================O");
        System.out.println("Loan Type: " + loan.getLoanType());
        System.out.printf("Balance: %.2f\n", loan.getRemainingBalance());
        System.out.printf("Your Monthly Payment: %.2f\n", loan.getMonthlyPayment());
        processPayment();
        System.out.println("O======================================================O");
    }

    public void processPayment() {

        System.out.print("How many months would you like to pay?: ");
        int months = input.nextInt();

        double totalAmountToPay = months * loan.getMonthlyPayment();
        double remainingBalance = loan.getRemainingBalance();

        if (totalAmountToPay >= remainingBalance) {
            System.out.printf("Adjusting payment to %.2f\n", remainingBalance);
            System.out.println("Your loan has been fully paid off.");
            loan.setRemainingBalance(0); 
        } else {
            remainingBalance -= totalAmountToPay;
            System.out.println("You are about to pay for " + months + " month(s).");
            System.out.printf("Your remaining balance is now: %.2f\n", remainingBalance);
            loan.setRemainingBalance(remainingBalance); 
        }
    }

    public boolean isLoanPaidOff() {
        return loan.getRemainingBalance() <= 0;
    }

    public void showCurrentBalance() {
        if (isLoanPaidOff()) {
            System.out.println("Your loan has been fully paid off.");
        } else {
            System.out.printf("Remaining Balance: %.2f\n", loan.getRemainingBalance());
        }
    }

}
