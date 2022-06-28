package T08IterstorsAndComparatorsExercises.E04Froggy;

import java.util.Iterator;
import java.util.List;

public class Lake implements Iterable<Integer>{
    private List<Integer> numbers;

    public Lake(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Frog();
    }

    private class Frog implements Iterator<Integer>{
        private int index;
        private boolean firstRoundFinished;

        public Frog() {
            this.index = 0;
            firstRoundFinished = false;
        }

        @Override
        public boolean hasNext() {
            return index < numbers.size();
        }

        @Override
        public Integer next() {
            int currentIndex = index;
            index += 2;

            if (index >= numbers.size() && !firstRoundFinished) {
                index = 1;
                firstRoundFinished = true;
            }

            return numbers.get(currentIndex);
        }
    }
}
