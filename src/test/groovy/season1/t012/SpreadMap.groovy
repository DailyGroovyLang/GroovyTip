package season1.t012

import spock.lang.Specification


class SpreadMap extends Specification {
    def "test"() {
        given: "Have key-valued list and need to convert it to Map? Try SpreadMap! #GroovyTip #groovylang"
        def book = ['title', 'The Martian Chronicles',
                    'author', 'Ray Bradbury']

        // equivalent to: def map = new SpreadMap(book)
        def map = book.toSpreadMap()

        assert map['author'] == 'Ray Bradbury'
        assert map['title'] == 'The Martian Chronicles'
    }
}