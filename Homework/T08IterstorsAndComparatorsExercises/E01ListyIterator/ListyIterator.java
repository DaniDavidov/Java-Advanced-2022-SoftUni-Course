package T08IterstorsAndComparatorsExercises.E01ListyIterator;

import java.util.List;

public class ListyIterator {
    private List<String> strings;
    private int index;

    public ListyIterator(List<String> strings) {
        this.strings = strings;
        this.index = 0;

    }

    public boolean move() {
        if (hasNext()) {
            index++;
            return true;
        }
        return false;
    }

    public void print() throws Exception {
        if (strings.isEmpty()) {
            throw new Exception("Invalid Operation!");
        }
        System.out.println(this.strings.get(this.index));
    }

    public boolean hasNext() {
        return index < strings.size() - 1;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public List<String> getStrings() {
        return strings;
    }

    public void setStrings(List<String> strings) {
        this.strings = strings;
    }


}
