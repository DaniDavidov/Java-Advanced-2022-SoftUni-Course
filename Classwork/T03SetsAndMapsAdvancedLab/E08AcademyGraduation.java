package T03SetsAndMapsAdvancedLab;

import java.text.DecimalFormat;
import java.util.*;

public class E08AcademyGraduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Double[]> contestantsByGrades = new TreeMap<>();

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String name = scanner.nextLine();
            String[] data = (scanner.nextLine().split("\\s+"));
            Double[] grades = new Double[data.length];

            for (int j = 0; j < grades.length; j++) {
                grades[j] = Double.parseDouble(data[j]);
            }
            contestantsByGrades.put(name, grades);
        }

        for (Map.Entry<String, Double[]> entry : contestantsByGrades.entrySet()) {
            double avg = Arrays.stream(entry.getValue()).mapToDouble(e -> e).average().orElse(0);
            String pattern ="#.###################################";
            DecimalFormat decimalFormat = new DecimalFormat(pattern);
            System.out.println(entry.getKey() + " is graduated with " + decimalFormat.format(avg));

        }

    }
}
