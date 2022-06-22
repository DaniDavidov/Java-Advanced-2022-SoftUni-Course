package T07GenericsExercises.GenericBox;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Comparable<T>> {
    List<T> elements;

    public Box() {
        this.elements = new ArrayList<>();
    }

    public void add (T element) {
        this.elements.add(element);
    }

    // returns the count of the elements with greater value than the given element
    public int countElements(T element) {
        if (this.elements.size() == 0) {
            throw new IllegalArgumentException();
        }
        int count = 0;
        for (T elementInList : elements) {
            if (elementInList.compareTo(element) > 0) {
                count++;
            }
        }
        return count;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (T element : elements) {
            sb.append(element.getClass().getName()).append(": ").append(element).append("\n");
        }
        return sb.toString();
    }


}
