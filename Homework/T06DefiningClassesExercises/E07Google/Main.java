package T06DefiningClassesExercises.E07Google;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Person> peopleData = new LinkedHashMap<>();

        String line;
        while (!"End".equals(line = scanner.nextLine())) {
            String[] data = line.split("\\s+");
            String name = data[0];
            String topic = data[1];

            if (!peopleData.containsKey(name)) {
                peopleData.put(name, new Person(name));
            }

            switch (topic) {
                case "company":
                    String companyName = data[2];
                    String department = data[3];
                    double salary = Double.parseDouble(data[4]);
                    Company company = new Company(companyName, department, salary);
                    peopleData.get(name).setCompany(company);

                    break;
                case "pokemon":
                    String pokemonName = data[2];
                    String pokemonType = data[3];
                    Pokemon pokemon = new Pokemon(pokemonName, pokemonType);
                    peopleData.get(name).getPokemons().add(pokemon);

                    break;
                case "parents":
                    String parentName = data[2];
                    String parentBirthday = data[3];
                    Parents parents = new Parents(parentName, parentBirthday);
                    peopleData.get(name).getParents().add(parents);

                    break;
                case "children":
                    String childName = data[2];
                    String childBirthday = data[3];
                    Children children = new Children(childName, childBirthday);
                    peopleData.get(name).getChildren().add(children);

                    break;
                case "car":
                    String carModel = data[2];
                    int carSpeed = Integer.parseInt(data[3]);
                    Car car = new Car(carModel, carSpeed);
                    peopleData.get(name).setCar(car);

                    break;
            }
        }
        String name = scanner.nextLine();
        System.out.println(peopleData.get(name).toString());
    }
}
