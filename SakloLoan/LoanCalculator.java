package SakloLoan;

import java.util.Scanner;

public class LoanCalculator {

    private double loanAmount;
    private int loanTerm; 
    private double annualInterestRate;
    private double monthlyInterestRate;
    private double monthlyPayment;
    private User user;

    Scanner input = new Scanner(System.in);

    public LoanCalculator(User user) {
        this.user = user; 
    }

    public void calculate() {
        System.out.println("O======================================================O");
        System.out.println("\t\t      LOAN CALCULATOR");
        System.out.println("O======================================================O");
        loanType();

        System.out.print("Enter loan amount: ");
        loanAmount = input.nextDouble();

        System.out.print("Enter loan term (in months): ");
        loanTerm = input.nextInt();

        monthlyInterestRate = (annualInterestRate / 100) / 12;

        monthlyPayment = calculateMonthlyPayment(loanAmount, monthlyInterestRate, loanTerm);
        System.out.printf("Monthly Payment: %.2f\n", monthlyPayment);
        System.out.println("O======================================================O");
    }

    private void loanType() {
        System.out.println("\nLoan Types:");
        System.out.println("1. Personal Loan");
        System.out.println("2. Car Loan");
        System.out.println("3. Education Loan");
        System.out.println("4. Healthcare Loan");
        System.out.println("5. Business Loan\n");

        System.out.print("Enter loan type (1-5): ");
        int loanType = input.nextInt();

        switch (loanType) {
            case 1: 
                annualInterestRate = 5.99;
                annualInterestRate = incomeBasedInterest(annualInterestRate);
                break;
            case 2: 
                annualInterestRate = 4.63;
                annualInterestRate = incomeBasedInterest(annualInterestRate);
                break;
            case 3: 
                annualInterestRate = 15.00;
                annualInterestRate = incomeBasedInterest(annualInterestRate);
                break;
            case 4: 
                annualInterestRate = 12.00;
                annualInterestRate = incomeBasedInterest(annualInterestRate);
                break;
            case 5: 
                annualInterestRate = 18.00;
                annualInterestRate = incomeBasedInterest(annualInterestRate);
                break;
            default:
                System.out.println("Invalid loan type. Setting default interest rate to 0%.");
                annualInterestRate = 0;
        }
    }

    private double incomeBasedInterest(double baseRate) {
        double income = user.getIncome();  

        if (income < 20000) {
            return baseRate + 5.0;
        } else if (income < 50000) {
            return baseRate + 2.0;  
        } else {
            return baseRate;
        }
    }


    private static double calculateMonthlyPayment(double principal, double monthlyInterestRate, int months) {
        if (monthlyInterestRate == 0) {
            return principal / months;  
        } else {
            return (principal * monthlyInterestRate * Math.pow(1 + monthlyInterestRate, months)) / 
                   (Math.pow(1 + monthlyInterestRate, months) - 1);
        }
    }
}
