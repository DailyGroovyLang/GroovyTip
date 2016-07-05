package tdg.t007

import spock.lang.Specification


class SortAndUniqueInCollections extends Specification {
    def "test"() {
        given: "Use the same comparator to sort and deduplicate collections. #GroovyTip #groovylang"

        def authors = ['Max Frei', 'Ray Bradbury', 'Max Frei', 'Douglas Adams']

        def sorted = authors.toSorted { o1, o2 -> o1 <=> o2 }
        assert sorted == ['Douglas Adams', 'Max Frei', 'Max Frei', 'Ray Bradbury']

        def unique = sorted.toUnique { o1, o2 -> o1 <=> o2 }
        assert unique == ['Douglas Adams', 'Max Frei', 'Ray Bradbury']
    }
}