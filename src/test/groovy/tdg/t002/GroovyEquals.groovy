package tdg.t002

import groovy.transform.EqualsAndHashCode
import spock.lang.Specification

class GroovyEquals extends Specification {

    @EqualsAndHashCode
    static class Book {
        String author

        Book(String author) {
            this.author = author
        }
    }

    def "test"() {
        given: "Try 'Groovy equals'"
        // try `==` instead of .equals(Object)
        def book1 = new Book('Author')
        def book2 = new Book('Author')
        assert book1 == book2 // book1.equals(books2)

        // and `is` for identity check
        assert !book1.is(book2) // java: book1 == books2
    }
}
