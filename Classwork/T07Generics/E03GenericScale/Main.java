package T07Generics.E03GenericScale;

public class Main {
    public static void main(String[] args) {

        Scale<Integer> scale = new Scale<>(5 ,6);
        Integer heavier = scale.getHeavier(5, 6);
        System.out.println(heavier);

        Scale<String> stringScale = new Scale<>("Pesho" , "Gosho");
        String heavierString = stringScale.getHeavier(stringScale.getLeft(), stringScale.getRight());
        System.out.println(heavierString);
    }
}
