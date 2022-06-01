package T06DefiningClassesExercises.E03SpeedRacing;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Car> cars = new LinkedHashMap<>();

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] data = scanner.nextLine().split("\\s+");
            String model = data[0];
            double fuelAmount = Double.parseDouble(data[1]);
            double fuelCostPerKM = Double.parseDouble(data[2]);

            Car car = new Car(model, fuelAmount, fuelCostPerKM);
            cars.put(model, car);
        }

        String line;
        while (!"End".equals(line = scanner.nextLine())) {
            String[] data = line.split("\\s+");
            String model = data[1];
            int amountKilometers = Integer.parseInt(data[2]);
            Car car = cars.get(model);
            car.calculateMileage(car.getFuelAmount(), car.getFuelCostPerKM(), car.getDistanceTraveled(), amountKilometers);

        }

        cars.forEach((model, car) -> System.out.printf("%s %.2f %d%n", model,
                car.getFuelAmount(), car.getDistanceTraveled()));
    }
}
