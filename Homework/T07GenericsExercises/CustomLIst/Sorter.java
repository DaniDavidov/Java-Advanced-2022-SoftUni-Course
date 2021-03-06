package T07GenericsExercises.CustomLIst;

public class Sorter {
    
    public static <T extends Comparable<T>> void sort(CustomList<T> list) {
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                if (list.get(i).compareTo(list.get(j)) < 0) {
                    list.swap(i, j);
                }
            }
        }
    }
}
