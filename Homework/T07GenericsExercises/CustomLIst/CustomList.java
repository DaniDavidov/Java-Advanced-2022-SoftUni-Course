package T07GenericsExercises.CustomLIst;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.function.Consumer;

public class CustomList<T extends Comparable<T>> implements Iterable<T> {
    private ArrayList<T> list;

    public CustomList() {
        this.list = new ArrayList<>();
    }

    public void add(T element) {
        this.list.add(element);
    }

    public void remove(int index) {
        this.list.remove(index);
    }

    public boolean contains(T element) {
        return this.list.contains(element);
    }

    public void swap(int firstIndex, int secondIndex) {
        T firstElement = this.list.get(firstIndex);
        T secondElement = this.list.get(secondIndex);

        this.list.set(firstIndex, secondElement);
        this.list.set(secondIndex, firstElement);
    }

    public int countGreater(T element) {
        if (this.list.size() == 0) {
            throw new IllegalArgumentException();
        }
        int count = 0;
        for (T elementInList : list) {
            if (elementInList.compareTo(element) > 0) {
                count++;
            }
        }
        return count;
    }

    public T getMax() {
        return Collections.max(this.list);
    }

    public T getMin() {
        return Collections.min(this.list);
    }

    public void print() {
        this.list.forEach(System.out::println);
    }

    public int size() {
        return this.list.size();
    }

    public T get(int index) {
        return list.get(index);
    }


    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public void forEach(Consumer<? super T> action) {
        Iterable.super.forEach(action);
    }

}
