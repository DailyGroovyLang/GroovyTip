package season1.t018

import spock.lang.Specification


class ObjectGraphBuilder extends Specification {
    def "test"() {
        given: "Did you know that #groovylang has an interesting and extensible DSL for constructing nesting objects? #GroovyTip"

        def builder = new groovy.util.ObjectGraphBuilder(classNameResolver: "tdg.t018")
        def library = builder.library(name: 'Central Library') {
            shelf() //empty
            shelf() {
                book(author: 'Famous Author')
            }
        }

        assert library.shelfs.size() == 2
        assert library.shelfs[1].books.size() == 1
        assert library.shelfs[1].books[0].author == 'Famous Author'
    }

}

class Library {
    String name
    List<Shelf> shelfs = []
    // because by default the expected array name is:
    // 'singular' + 's'
}

class Shelf {
    List<Book> books = []
}

class Book {
    String author
}