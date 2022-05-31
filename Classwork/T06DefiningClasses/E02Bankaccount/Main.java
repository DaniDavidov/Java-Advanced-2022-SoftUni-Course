package T06DefiningClasses.E02Bankaccount;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Integer, BankAccount> bankAccounts = new LinkedHashMap<>();

        String line;
        while (!"End".equals(line = scanner.nextLine())) {
            String[] data = line.split("\\s+");
            String command = data[0];

            switch (command) {
                case "Create":
                    BankAccount bankAccount = new BankAccount();
                    bankAccounts.put(bankAccount.getId(),bankAccount);
                    System.out.printf("Account ID%d created%n", bankAccount.getId());
                    break;
                case "Deposit":
                    int id = Integer.parseInt(data[1]);
                    int deposit = Integer.parseInt(data[2]);
                    if (bankAccounts.containsKey(id)) {
                        bankAccounts.get(id).deposit(deposit);
                        System.out.printf("Deposited %d to ID%d%n", deposit, id);
                    } else {
                        System.out.println("Account does not exist");
                    }

                    break;
                case "SetInterest":
                    double interest = Double.parseDouble(data[1]);
                    BankAccount.setInterestRate(interest);
                    break;
                case "GetInterest":
                    id = Integer.parseInt(data[1]);
                    int years = Integer.parseInt(data[2]);

                    if (bankAccounts.containsKey(id)) {
                        double currentInterest = bankAccounts.get(id).getInterest(years);
                        System.out.println(currentInterest);
                    } else {
                        System.out.println("Account does not exist");
                    }
                    break;
            }

        }
    }
}
