package T03SetsAndMapsAdvancedLab;

import java.util.*;
import java.util.stream.Collectors;

public class E05AverageStudentsGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<Double>> studentsByGrades = new TreeMap<>();

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] data = scanner.nextLine().split("\\s+");
            String student = data[0];
            double grade = Double.parseDouble(data[1]);

            studentsByGrades.putIfAbsent(student, new ArrayList<>());
            studentsByGrades.get(student).add(grade);

        }
        for (Map.Entry<String, List<Double>> entry : studentsByGrades.entrySet()) {
            double avg = entry.getValue()
                    .stream().mapToDouble(e -> e)
                    .average().orElse(0);
            List<String> grades = entry.getValue().stream()
                            .map(e -> String.format("%.2f", e))
                            .collect(Collectors.toList());
            System.out.printf("%s -> %s (avg: %.2f)%n", entry.getKey(), String.join(" ", grades), avg);

        }
    }
}
