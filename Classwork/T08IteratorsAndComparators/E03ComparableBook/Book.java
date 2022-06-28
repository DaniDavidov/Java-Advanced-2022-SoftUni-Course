package T08IteratorsAndComparators.E03ComparableBook;

import java.util.ArrayList;
import java.util.List;

public class Book implements Comparable<Book> {
    private String title;
    private int year;
    private ArrayList<String> authors;

    public Book(String title, int year, String... authors) {
        this.title = title;
        this.year = year;
        this.authors = new ArrayList<>(List.of(authors));
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public ArrayList<String> getAuthors() {
        return authors;
    }

    public void setAuthors(ArrayList<String> authors) {
        this.authors = authors;
    }

    @Override
    public int compareTo(Book o) {
        int result = this.getTitle().compareTo(o.getTitle());

        if (result == 0) {
            return Integer.compare(this.getYear(), o.getYear());
        }
        return result;
    }
}
