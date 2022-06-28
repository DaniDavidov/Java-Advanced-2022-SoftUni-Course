package T08IterstorsAndComparatorsExercises.E06StrategyPattern;


import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        NamesComparator namesComparator = new NamesComparator();
        AgeComparator ageComparator = new AgeComparator();
        Set<Person> sortedByName = new TreeSet<>(namesComparator);
        Set<Person> sortedByAge = new TreeSet<>(ageComparator);

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] data = scanner.nextLine().split("\\s+");
            String name = data[0];
            int age = Integer.parseInt(data[1]);

            Person person = new Person(name, age);
            sortedByName.add(person);
            sortedByAge.add(person);
        }

        sortedByName.forEach(e -> System.out.println(e.getName() + " " + e.getAge()));
        sortedByAge.forEach(e -> System.out.println(e.getName() + " " + e.getAge()));
    }
}
