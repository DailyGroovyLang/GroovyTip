package season1.t009

import groovy.transform.Immutable
import spock.lang.Specification

public class OmitParentheses extends Specification {
    def "test"() {
        def book = new Book()
        given: "Try to omit parentheses around the arguments and dots between chained calls to make you DSL more clear #GroovyTip"

        // equivalent to: open(book).on().page(3)
        Page page = LibraryDsl.open(book).on().page(3)

        assert page.number == 3
    }
}

class Book {
}

@Immutable
class Page {
    int number
}

class LibraryDsl {
    int page

    static LibraryDsl open(Book book) {
        return new LibraryDsl()
    }

    Page page(int page) {
        this.page = page
        return new Page(3)
    }

    LibraryDsl on() {
        return this
    }
}
