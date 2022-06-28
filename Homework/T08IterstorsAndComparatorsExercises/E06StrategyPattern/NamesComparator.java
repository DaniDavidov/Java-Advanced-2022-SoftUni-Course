package T08IterstorsAndComparatorsExercises.E06StrategyPattern;

import java.util.Comparator;
import java.util.Locale;

public class NamesComparator implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        int result = Integer.compare(o1.getName().length(), o2.getName().length());

        if (result == 0) {
            result = o1.getName().toLowerCase(Locale.ROOT).compareTo(o2.getName().toLowerCase(Locale.ROOT));
        }
        return result;
    }
}