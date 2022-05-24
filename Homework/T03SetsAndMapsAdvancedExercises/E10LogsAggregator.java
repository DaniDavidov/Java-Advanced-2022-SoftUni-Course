package T03SetsAndMapsAdvancedExercises;

import java.util.*;

public class E10LogsAggregator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Set<String>> usersByIPs = new TreeMap<>();
        Map<String, Integer> usersByDuration = new TreeMap<>();

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] data = scanner.nextLine().split("\\s+");
            String ip = data[0];
            String user = data[1];
            int duration = Integer.parseInt(data[2]);

            usersByIPs.putIfAbsent(user, new TreeSet<>());
            usersByIPs.get(user).add(ip);
            usersByDuration.putIfAbsent(user, 0);
            usersByDuration.put(user, usersByDuration.get(user) + duration);
        }

        printResults(usersByIPs, usersByDuration);
    }

    private static void printResults(Map<String, Set<String>> usersByIPs, Map<String, Integer> usersByDuration) {
        for (Map.Entry<String, Set<String>> entry : usersByIPs.entrySet()) {
            String name = entry.getKey();
            String IPs = String.join(", ", entry.getValue());
            System.out.printf("%s: %d [%s]%n", name, usersByDuration.get(name), IPs);
        }

    }
}
