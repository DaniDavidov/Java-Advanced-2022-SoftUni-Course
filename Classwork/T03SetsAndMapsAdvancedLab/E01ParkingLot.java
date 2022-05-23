package T03SetsAndMapsAdvancedLab;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class E01ParkingLot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> registrationNumbers = new LinkedHashSet<>();

        String line = scanner.nextLine();
        while (!line.equals("END")) {
            String[] data = line.split(", ");
            String direction = data[0];
            String registrationNum = data[1];

            switch (direction) {
                case "IN":
                    registrationNumbers.add(registrationNum);
                    break;
                case "OUT":
                    registrationNumbers.remove(registrationNum);
                    break;
            }

            line = scanner.nextLine();
        }
        if (registrationNumbers.isEmpty()) {
            System.out.println("Parking Lot is Empty");
        }

        for (String s : registrationNumbers) {
            System.out.println(s);
        }
    }
}
