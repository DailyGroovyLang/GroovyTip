package season1.t024

import spock.lang.Specification


class TakeAndTakeRight extends Specification {
    def "test"() {
        given: "Need some elements from head or tail of the list? Try 'take*' methods #GroovyTip #groovylang"

        def list = [1, 2, 3]

        assert list.take(2) == [1, 2]
        assert list.takeRight(2) == [2, 3]

        assert list.take(42) == list
    }
}