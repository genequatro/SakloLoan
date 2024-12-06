package SakloLoan;

import java.util.Scanner;

public abstract class Loan {

    static Scanner input = new Scanner(System.in);
    protected User user;
    protected double monthlyPayment;
    protected double loanAmount;  
    protected double remainingBalance; 

    public Loan(User user) {
        this.user = user;
    }

    public double getMonthlyPayment() {
        return monthlyPayment;
    }

    public double getLoanAmount() {
        return loanAmount;
    }

    public double getRemainingBalance() {
        return remainingBalance;
    }

    public void setRemainingBalance(double remainingBalance) {
        this.remainingBalance = remainingBalance;
    }

    public abstract String getLoanType(); 
    public abstract void applyLoan();


    public static class PersonalLoan extends Loan {
        public PersonalLoan(User user) {
            super(user);
        }

        @Override
        public String getLoanType() {
            return "Personal Loan";
        }

        @Override
        public void applyLoan() {

            System.out.print("\nEnter loan amount: ");
            loanAmount = input.nextDouble();

            System.out.print("Enter loan term (in months): ");
            int months = input.nextInt();

            double annualInterestRate = 5.00;
            annualInterestRate = incomeBasedInterest(annualInterestRate, user);
            double monthlyInterestRate = (annualInterestRate / 100) / 12;

            this.monthlyPayment = calculateMonthlyPayment(loanAmount, monthlyInterestRate, months);

            remainingBalance = loanAmount;

            System.out.printf("The monthly payment is: %.2f\n" + "\n", monthlyPayment);
        }
    }

    public static class CarLoan extends Loan {
        public CarLoan(User user) {
            super(user);
        }

        @Override
        public String getLoanType() {
            return "Car Loan";
        }

        @Override
        public void applyLoan() {

            System.out.print("\nEnter loan amount: ");
            loanAmount = input.nextDouble();

            System.out.print("Enter loan term (in months): ");
            int months = input.nextInt();

            double annualInterestRate = 6.00;
            annualInterestRate = incomeBasedInterest(annualInterestRate, user);
            double monthlyInterestRate = (annualInterestRate / 100) / 12;

            this.monthlyPayment = calculateMonthlyPayment(loanAmount, monthlyInterestRate, months);

            remainingBalance = loanAmount;

            System.out.printf("The monthly payment is: %.2f\n" + "\n", monthlyPayment);
        }

    }

    public static class EducationLoan extends Loan {
        public EducationLoan(User user) {
            super(user);
        }

        @Override
        public String getLoanType() {
            return "Education Loan";
        }

        @Override
        public void applyLoan() {

            System.out.print("\nEnter loan amount: ");
            loanAmount = input.nextDouble();

            System.out.print("Enter loan term (in months): ");
            int months = input.nextInt();

            double annualInterestRate = 12.00;
            annualInterestRate = incomeBasedInterest(annualInterestRate, user);
            double monthlyInterestRate = (annualInterestRate / 100) / 12;

            this.monthlyPayment = calculateMonthlyPayment(loanAmount, monthlyInterestRate, months);

            remainingBalance = loanAmount;

            System.out.printf("The monthly payment is: %.2f\n" + "\n", monthlyPayment);
        }

    }

    public static class HealthcareLoan extends Loan {
        public HealthcareLoan(User user) {
            super(user);
        }

        @Override
        public String getLoanType() {
            return "Healthcare Loan";
        }

        @Override
        public void applyLoan() {

            System.out.print("\nEnter loan amount: ");
            loanAmount = input.nextDouble();

            System.out.print("Enter loan term (in months): ");
            int months = input.nextInt();

            double annualInterestRate = 12.00;
            annualInterestRate = incomeBasedInterest(annualInterestRate, user);                

            double monthlyInterestRate = (annualInterestRate / 100) / 12;

            this.monthlyPayment = calculateMonthlyPayment(loanAmount, monthlyInterestRate, months);

            remainingBalance = loanAmount;

            System.out.printf("The monthly payment is: %.2f\n" + "\n", monthlyPayment);
        }

    }

    public static class BusinessLoan extends Loan {
        public BusinessLoan(User user) {
            super(user);
        }

        @Override
        public String getLoanType() {
            return "Business Loan";
        }

        @Override
        public void applyLoan() {

            System.out.print("\nEnter loan amount: ");
            loanAmount = input.nextDouble();

            System.out.print("Enter loan term (in months): ");
            int months = input.nextInt();

            double annualInterestRate = 18.00;
            annualInterestRate = incomeBasedInterest(annualInterestRate, user);
            double monthlyInterestRate = (annualInterestRate / 100) / 12;

            this.monthlyPayment = calculateMonthlyPayment(loanAmount, monthlyInterestRate, months);

            remainingBalance = loanAmount;

            System.out.printf("The monthly payment is: %.2f\n" + "\n", monthlyPayment);
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

    public void processPayment(double paymentAmount) {
        if (paymentAmount >= remainingBalance) {
            remainingBalance = 0;  
            System.out.println("Your loan has been paid off.");
        } else {
            remainingBalance -= paymentAmount;
            System.out.printf("Remaining Balance: %.2f\n", remainingBalance);
        }
    }

    private static double incomeBasedInterest(double baseRate, User user) {
        double income = user.getIncome();  

        if (income < 20000) {
            return baseRate - 3.5;
        } else if (income < 50000) {
            return baseRate - 2.0;  
        } else {
            return baseRate;
        }
    }
}
