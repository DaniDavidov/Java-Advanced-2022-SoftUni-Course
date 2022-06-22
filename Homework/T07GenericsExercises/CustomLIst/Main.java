package T07GenericsExercises.CustomLIst;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CustomList<String> list = new CustomList<>();

        String line;
        while (!"END".equals(line = scanner.nextLine())) {
            String[] data = line.split("\\s+");
            String command = data[0];

            switch (command) {
                case "Add":
                    String element = data[1];
                    list.add(element);
                    break;
                case "Remove":
                    int index = Integer.parseInt(data[1]);
                    list.remove(index);
                    break;
                case "Contains":
                    element = data[1];
                    System.out.println(list.contains(element));
                    break;
                case "Swap":
                    int index1 = Integer.parseInt(data[1]);
                    int index2 = Integer.parseInt(data[2]);
                    list.swap(index1, index2);
                    break;
                case "Greater":
                    element = data[1];
                    System.out.println(list.countGreater(element));
                    break;
                case "Max":
                    System.out.println(list.getMax());
                    break;
                case "Min":
                    System.out.println(list.getMin());
                    break;
                case "Print":
                    list.print();
                    break;
                case "Sort":
                    Sorter.sort(list);
                    break;
            }
        }
    }
}
