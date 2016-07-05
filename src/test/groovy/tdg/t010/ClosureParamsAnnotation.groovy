package tdg.t010

import groovy.transform.stc.ClosureParams
import groovy.transform.stc.FirstParam
import spock.lang.Specification


class ClosureParamsAnnotation extends Specification {
    def processBooks(List<Book> books,
                     @ClosureParams(FirstParam.FirstGenericType) Closure<?> processor) {
        /*...*/ books.each processor
    }

    def "test"() {
        given: "Suggest your IDE how to deal with closure with the help of ClosureParams annotation. #GroovyTip #groovylang"

        def book = new Book(author: '<n/a>')

        processBooks([book]) { b ->
            b.author = 'John Doe' // <- code completion (⌐■_■)
        }

        assert book.author == 'John Doe'
    }
}

class Book {
    String author
}