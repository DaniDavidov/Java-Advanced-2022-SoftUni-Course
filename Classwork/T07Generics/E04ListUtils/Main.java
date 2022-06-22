package T07Generics.E04ListUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Integer> numbers = new ArrayList<>();
        Collections.addAll(numbers, 5, 8, 17, 20, 5, 6);
        System.out.println(ListUtils.getMin(numbers));
    }
}
