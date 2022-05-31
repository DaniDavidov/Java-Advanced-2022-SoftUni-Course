package T06DefiningClasses.E01CarInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Car> cars = new ArrayList<>();

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] data = scanner.nextLine().split("\\s+");
            Car car;

            if (data.length < 3) {
                car = new Car(data[0]);
            } else {
                car = new Car(data[0], data[1], Integer.parseInt(data[2]));
            }
            cars.add(car);
        }
        cars.forEach(car -> System.out.println(car.carInfo()));
    }
}
