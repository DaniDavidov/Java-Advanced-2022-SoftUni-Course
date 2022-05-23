package T03SetsAndMapsAdvancedLab;

import java.util.*;

public class E07CitiesByContinentAndCountry {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Map<String, List<String>>> places = new LinkedHashMap<>();

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] data = scanner.nextLine().split("\\s+");
            String continent = data[0];
            String country = data[1];
            String city = data[2];

            places.putIfAbsent(continent, new LinkedHashMap<>());
            places.get(continent).putIfAbsent(country, new ArrayList<>());
            places.get(continent).get(country).add(city);
        }

        for (Map.Entry<String, Map<String, List<String>>> continent : places.entrySet()) {
            System.out.println(continent.getKey() + ":");

            for (Map.Entry<String, List<String>> entry : continent.getValue().entrySet()) {
                System.out.printf("  %s -> %s%n", entry.getKey(), String.join(", ", entry.getValue()));
            }

        }

    }
}
