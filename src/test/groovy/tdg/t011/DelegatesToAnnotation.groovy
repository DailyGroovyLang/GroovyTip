package tdg.t011

import spock.lang.Specification


class DelegatesToAnnotation extends Specification {
    def processBooks2(@DelegatesTo.Target List<Book> books,
                      @DelegatesTo(genericTypeIndex = 0)
                              Closure<?> processor) {
        /*...*/
        books.each {
            Closure<Void> p = processor.clone()
            p.delegate = it
            p.call()
        }
    }

    def "test"() {
        given: "Continue to suggest your IDE how to work with closure delegate with the help of DelegatesTo annotation. #GroovyTip #groovylang"

        def book = new Book(author: '<n/a>')

        processBooks2([book]) {
            // assuming that call of closure is delegated to instance of Book
            author = 'John Doe' // <- code completion (⌐■_■)
        }

        assert book.author == 'John Doe'
    }
}

class Book {
    String author
}