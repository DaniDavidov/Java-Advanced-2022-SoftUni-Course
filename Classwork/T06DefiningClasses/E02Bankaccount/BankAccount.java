package T06DefiningClasses.E02Bankaccount;

public class BankAccount {
    private int id;
    private double balance;
    private static double interestRate = 0.02;
    private int bankAccountCount = 1;

    public BankAccount() {
        this.id = bankAccountCount++;
    }

    public static void setInterestRate(double interestRate) {
        BankAccount.interestRate = interestRate;
    }

    public double getInterest(int years) {
        return years * interestRate * this.balance;
    }

    public void deposit(int deposit) {
        this.balance += deposit;
    }
    public int getId() {
        return this.id;
    }

}
