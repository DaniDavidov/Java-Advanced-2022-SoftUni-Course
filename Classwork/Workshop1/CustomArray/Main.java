package Workshop1.CustomArray;

public class Main {
    public static void main(String[] args) {

        SmartArray smartArray = new SmartArray();

        for (int i = 1; i <= 20; i++) {
            smartArray.add(i);
        }

        int removed = smartArray.remove(5);

        smartArray.add(4, 15);

        smartArray.forEach(System.out::println);
    }
}
