package T03SetsAndMapsAdvancedExercises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class E09PopulationCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Map<String, Long>> countries = new LinkedHashMap<>();

        String line;
        while (!"report".equals(line = scanner.nextLine())) {
            String[] data = line.split("\\|");
            String city = data[0];
            String country = data[1];
            long population = Long.parseLong(data[2]);

            countries.putIfAbsent(country, new LinkedHashMap<>());
            countries.get(country).put(city, population);
        }

        Map<String, Long> countriesByTotalPopulation = CalculateTotalPopulation(countries);
        printResults(countries, countriesByTotalPopulation);
    }

    private static void printResults(Map<String, Map<String, Long>> countries, Map<String, Long> countriesByTotalPopulation) {
        countriesByTotalPopulation.entrySet().stream().sorted((a, b) -> {
            return b.getValue().compareTo(a.getValue());
        }).forEach(e -> {
            System.out.printf("%s (total population: %s)%n", e.getKey(), e.getValue());
            countries.get(e.getKey()).entrySet().stream().sorted((a, b) -> {
                return b.getValue().compareTo(a.getValue());
            }).forEach(a -> System.out.printf("=>%s: %d%n", a.getKey(), a.getValue()));
        });
    }

    private static Map<String, Long> CalculateTotalPopulation(Map<String, Map<String, Long>> countries) {
        Map<String, Long> populationMap = new LinkedHashMap<>();
        for (Map.Entry<String, Map<String, Long>> entry : countries.entrySet()) {
            long totalPopulation = entry.getValue().values().stream().mapToLong((e -> e)).sum();
            populationMap.put(entry.getKey(), totalPopulation);
        }
        return populationMap;
    }
}
