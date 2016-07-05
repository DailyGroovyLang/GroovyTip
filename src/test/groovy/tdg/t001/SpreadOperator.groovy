package tdg.t001

import groovy.transform.EqualsAndHashCode
import spock.lang.Specification


class SpreadOperator extends Specification {

    @EqualsAndHashCode
    static class Book {
        String isbn
    }

    List<Book> books = [new Book()]

    def "test"() {
        given: "Use spread operator"
        //use
        books*.isbn
        //instead of
        books.collect { it.isbn }
    }
}