package T07Generics.E02GenericArrayCreator;

public class Main {
    public static void main(String[] args) {

        Integer[] arr1 = ArrayCreator.create(5, 15);
        String[] arr2 = ArrayCreator.create(String.class, 5, "Dani");
    }
}
