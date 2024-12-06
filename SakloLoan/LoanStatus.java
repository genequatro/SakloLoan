package SakloLoan;

public class LoanStatus {

    private Loan loan;

    public LoanStatus(Loan loan) {
        this.loan = loan;
    }

    public void displayLoanStatus() {
        if (loan.getRemainingBalance() <= 0) {
            System.out.println("Your loan has been paid off.");
        } else {
            System.out.println("O======================================================O");
            System.out.println("\t\t\tLOAN STATUS");
            System.out.println("O======================================================O");
            System.out.println("Name: " + loan.user.getName());
            System.out.println("Address: " + loan.user.getAddress());
            System.out.println("Age: " + loan.user.getAge());
            System.out.println("Date of Birth: " + loan.user.getBirthday());
            System.out.println("Phone Number: " + loan.user.getNumber());

            System.out.println("Loan Type: " + loan.getLoanType());
            System.out.println("Loan Amount: " + loan.getLoanAmount());

            System.out.printf("Balance: %.2f\n", loan.getRemainingBalance());

            int monthsLeft = (int) (loan.getRemainingBalance() / loan.getMonthlyPayment());
            if (loan.getRemainingBalance() % loan.getMonthlyPayment() != 0) {
                monthsLeft += 1; 
            }

            System.out.println("Months Left to Pay: " + monthsLeft);
            System.out.println("O======================================================O");
        }
    }
}
