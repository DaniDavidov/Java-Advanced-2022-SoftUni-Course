package T07Generics.E02GenericArrayCreator;

import java.lang.reflect.Array;

public class ArrayCreator {

    public static <T> T[] create(int length, T element) {
        T[] array = (T[]) Array.newInstance(element.getClass(), length);
        for (int i = 0; i < length; i++) {
            array[i] = element;
        }
        return array;
    }

    public static <T> T[] create(Class<T> tClass, int length, T element) {
        T[] array = (T[]) Array.newInstance(tClass, length);
        for (int i = 0; i < length; i++) {
            array[i] = element;
        }
        return array;
    }
}
