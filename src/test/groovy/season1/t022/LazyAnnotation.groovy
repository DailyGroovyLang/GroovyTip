package season1.t022

import spock.lang.Specification


class LazyAnnotation extends Specification {
    def "test"() {
        given: "Did you know that #groovylang has Lazy annotation that supports soft refs and double-checked locking #GroovyTip"

        def phrase = new Phrase()

        assert phrase.last == phrase.first + 'initialized,' + 'Lazy field,'
        assert phrase.first == 'Eager field,'
    }
}

class Phrase {
    static String buffer = ''

    def first = { buffer += 'Eager field,' }()
    @Lazy def last = { buffer += 'Lazy field,' }()

    Phrase() {
        buffer += 'initialized,'
    }
}