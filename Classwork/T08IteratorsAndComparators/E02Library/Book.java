package T08IteratorsAndComparators.E02Library;

import java.util.ArrayList;
import java.util.List;

public class Book {
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

}
