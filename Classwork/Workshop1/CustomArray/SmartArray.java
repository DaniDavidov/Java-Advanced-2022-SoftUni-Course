package Workshop1.CustomArray;

import java.util.function.Consumer;

public class SmartArray {
    private Integer[] data;
    private static final int INITIAL_CAPACITY = 4;
    int size;

    public SmartArray() {
        this.data = new Integer[INITIAL_CAPACITY];
        this.size = 0;
    }

    public void forEach(Consumer<Integer> consumer) {
        for (int i = 0; i < this.size; i++) {
            Integer e = this.data[i];
            consumer.accept(e);
        }
    }

    public void add(int index, int element) {
        validateIndex(index);

        int lastElement = this.data[this.size-1];

        for (int i = this.size - 1; i > index; i--) {
            this.data[i] = this.data[i - 1];
        }
        this.data[index] = element;
        add(lastElement);
    }

    public boolean contains(int element) {
        for (int i = 0; i < this.size; i++) {
            if (this.data[i] == element) {
                return true;
            }
        }
        return false;
    }

    public int size() {
        return this.size;
    }

    public int remove(int index) {
        validateIndex(index);

        int removedElement = this.data[index];
        this.size--;
        for (int i = index; i < this.size; i++) {
            this.data[i] = this.data[i+1];
        }
        this.data[this.size] = null;

        if (this.data.length / 4 >= this.size && this.size > INITIAL_CAPACITY) {
            this.data = shrink();
        }

        return removedElement;
    }

    private Integer[] shrink() {
        Integer[] newData = new Integer[this.data.length / 2];

        System.arraycopy(this.data, 0, newData, 0, newData.length);
        return newData;
    }

    public int get(int index) {
        validateIndex(index);

        return this.data[index];
    }

    private void validateIndex(int index) {
        if (0 > index || index >= this.size) {
            throw new IndexOutOfBoundsException("Invalid index " + index);
        }
    }

    public void add(int element) {
        if (this.size == this.data.length - 1) {
            this.data = grow();
        }

        this.data[this.size] = element;
        this.size++;
    }

    private Integer[] grow() {
        Integer[] newData = new Integer[this.data.length * 2];

        System.arraycopy(this.data, 0, newData, 0, this.data.length);
        return newData;
    }
}
