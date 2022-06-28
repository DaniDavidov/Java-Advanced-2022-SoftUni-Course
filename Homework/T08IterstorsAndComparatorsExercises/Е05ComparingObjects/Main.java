package T08IterstorsAndComparatorsExercises.Е05ComparingObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Person> people = new ArrayList<>();

        String line;
        while (!"END".equals(line = scanner.nextLine())) {
            String[] data = line.split("\\s+");
            String name = data[0];
            int age = Integer.parseInt(data[1]);
            String town = data[2];

            Person person = new Person(name, age, town);
            people.add(person);
        }

        int index = Integer.parseInt(scanner.nextLine()) - 1;
        Person person = people.get(index);

        int countOfEqualPeople = 0;
        for (int i = 0; i < people.size(); i++) {
            if (i == index) {
                continue;
            }
            if (person.compareTo(people.get(i)) == 0) {
                countOfEqualPeople++;
            }
        }

        int countOfNotEqualPeople = people.size() - countOfEqualPeople;
        System.out.printf("%d %d %d", countOfEqualPeople, countOfNotEqualPeople, people.size());
    }
}
