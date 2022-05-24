package T03SetsAndMapsAdvancedExercises;

import java.util.*;

public class E08UserLogs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Map<String, Integer>> userLogs = new TreeMap<>();

        String line = scanner.nextLine();
        while (!line.equals("end")) {
            String[] data = line.split("\\s+");

            // Extracting the data form the input
            String ip = data[0].substring(data[0].indexOf('=')+1);
            String message = data[1].substring(data[1].indexOf('=')+1);
            String user = data[2].substring(data[2].indexOf('=')+1);

            // Insert the data in the map
            insertData(userLogs, user, ip);

            line = scanner.nextLine();
        }

        // printing the results
        printUsers(userLogs);
    }

    private static void printUsers(Map<String, Map<String, Integer>> userLogs) {

        for (Map.Entry<String, Map<String, Integer>> user : userLogs.entrySet()) {
            System.out.println(user.getKey() + ":");

            List<String> outputLines = new ArrayList<>();
            for (Map.Entry<String, Integer> entry : user.getValue().entrySet()) {
                outputLines.add(String.format("%s => %d", entry.getKey(), entry.getValue()));
            }
            System.out.println(String.join(", ", outputLines) + ".");

        }

    }

    private static void insertData(Map<String, Map<String, Integer>> userLogs, String user, String ip) {
        userLogs.putIfAbsent(user, new LinkedHashMap<>());
        userLogs.get(user).putIfAbsent(ip, 0);
        userLogs.get(user).put(ip, userLogs.get(user).get(ip) + 1);
    }
}
