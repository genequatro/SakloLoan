package SakloLoan;

import java.util.Scanner;

public class ApplyLoan {

    private Scanner input = new Scanner(System.in);
    private User user;

    public ApplyLoan(User user) {
        this.user = user;
    }

    public Loan applyLoan() {
        System.out.println("O======================================================O");
        System.out.println("\t\t\tAPPLY LOAN");
        System.out.println("O======================================================O");
        System.out.println("\t1. Personal Loan\t 3. Education Loan");
        System.out.println("\t2. Car Loan\t\t 4. Healthcare Loan");
        System.out.println("\t\t   5. Business Loan");
        System.out.println("O======================================================O");

        System.out.print("Enter loan type (1-5): ");
        int loanType = input.nextInt();

        Loan loan = null;

        switch (loanType) {
            case 1:
                loan = new Loan.PersonalLoan(user);
                break;
            case 2:
                loan = new Loan.CarLoan(user);
                break;
            case 3:
                loan = new Loan.EducationLoan(user);
                break;
            case 4:
                loan = new Loan.HealthcareLoan(user);
                break;
            case 5:
                loan = new Loan.BusinessLoan(user);
                break;
            default:
                System.out.println("Invalid option.");
                return null;
        }

        if (loan != null) {
            System.out.println("O======================================================O");
            loan.applyLoan(); 
            System.out.println("Your loan has been approved!\n");
            System.out.println("O======================================================O");
        }

        return loan;  
    }
}
