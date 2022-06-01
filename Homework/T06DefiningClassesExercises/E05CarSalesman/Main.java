package T06DefiningClassesExercises.E05CarSalesman;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Engine> engineMap = new LinkedHashMap<>();
        List<Car> cars = new ArrayList<>();

        int numberOfEngines = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numberOfEngines; i++) {
            String[] data = scanner.nextLine().split("\\s+");
            String model = data[0];
            int power = Integer.parseInt(data[1]);
            String displacements = "n/a";
            String efficiency = "n/a";

            Engine engine;
            if (data.length == 2) {
                engine = new Engine(model, power, displacements, efficiency);
            } else if (data.length == 3) {
                if (Character.isDigit(data[2].charAt(0))) {
                    displacements = data[2];
                } else {
                    efficiency = data[2];
                }
                engine = new Engine(model, power, displacements, efficiency);
            } else {
                displacements = data[2];
                efficiency = data[3];
                engine = new Engine(model, power, displacements, efficiency);
            }
            engineMap.put(model, engine);
        }

        int numberOfCars = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numberOfCars; i++) {
            String[] data = scanner.nextLine().split("\\s+");
            String model = data[0];
            String engineModel = data[1];
            String weight = "n/a";
            String color = "n/a";
            Engine engine = engineMap.get(engineModel);


            Car car;
            if (data.length == 2) {
                car = new Car(model, engine, weight, color);
            } else if (data.length == 3) {
                if (Character.isDigit(data[2].charAt(0))) {
                    weight = data[2];
                } else {
                    color = data[2];
                }
                car = new Car(model, engine, weight, color);
            } else {
                weight = data[2];
                color = data[3];
                car = new Car(model, engine, weight, color);
            }
            cars.add(car);
        }
        cars.forEach(car -> System.out.println(car.toString()));
    }
}
