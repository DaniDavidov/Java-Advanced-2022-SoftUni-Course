package T07GenericsExercises.GenericSwapMethodStrings;

import java.util.ArrayList;
import java.util.List;

public class Elements<T> {
    private List<T> elements;

    public Elements() {
        this.elements = new ArrayList<>();
    }

    public void add(T element) {
        this.elements.add(element);
    }

    public void swap(int firstIndex, int secondIndex) {
        T firstElement = this.elements.get(firstIndex);
        T secondElement = this.elements.get(secondIndex);

        this.elements.set(firstIndex, secondElement);
        this.elements.set(secondIndex, firstElement);
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
