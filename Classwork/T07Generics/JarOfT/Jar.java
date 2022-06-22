package T07Generics.JarOfT;

import java.lang.reflect.Array;
import java.util.ArrayDeque;

public class Jar<T> {
    private ArrayDeque<T> stack;

    public Jar() {
        stack = new ArrayDeque<>();
    }

    public void add(T element) {
        this.stack.add(element);
    }

    public T remove() {
        return this.stack.pop();
    }

}
