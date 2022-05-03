package season1.t015;

import java.util.Objects;

public class BookService {

    MetaProvider metaProvider;

    public BookService(MetaProvider metaProvider) {
        this.metaProvider = metaProvider;
    }

    public Book getBook(String isbn) {
        Meta meta = metaProvider.getMeta(isbn);
        return new Book(meta.author, meta.title, meta.isbn);
    }

    public interface MetaProvider {
        Meta getMeta(String isbn);
    }

    public static class Meta {
        String author;
        String title;
        String isbn;

        public Meta(String author, String title, String isbn) {
            this.author = author;
            this.title = title;
            this.isbn = isbn;
        }
    }

    public static class Book {
        public String author;
        public String title;
        public String isbn;

        public Book(String author, String title, String isbn) {
            this.author = author;
            this.title = title;
            this.isbn = isbn;
        }

        @Override public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Book book = (Book) o;
            return Objects.equals(author, book.author) &&
                    Objects.equals(title, book.title) &&
                    Objects.equals(isbn, book.isbn);
        }

        @Override public int hashCode() {
            return Objects.hash(author, title, isbn);
        }
    }
}
