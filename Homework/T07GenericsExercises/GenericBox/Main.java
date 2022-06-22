package T07GenericsExercises.GenericBox;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        //Problem 1
        /*Box<String> box = new Box<>();

        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            box.add(line);
        }

        System.out.println(box.toString());
        */

       //Problem 2
        /*Box<Integer> box = new Box<>();

        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(scanner.nextLine());
            box.add(number);
        }

        System.out.println(box.toString());
        */

        // Problem 5
        /*Box<String> box = new Box<>();

        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            box.add(line);
        }

        String element = scanner.nextLine();
        int count = box.countElements(element);
        System.out.println(count);

         */


        // Problem 6
        Box<Double> box = new Box<>();

        for (int i = 0; i < n; i++) {
            Double number = Double.parseDouble(scanner.nextLine());
            box.add(number);
        }

        Double element = Double.parseDouble(scanner.nextLine());
        int count = box.countElements(element);
        System.out.println(count);

    }
}
