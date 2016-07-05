package tdg.t008

import groovy.transform.Memoized
import spock.lang.Specification


class MemoizedAnnotation extends Specification {
    def "test"() {
        given: "Try Memoized Annotation to cache results. #GroovyTip #groovylang"
        def service = new RememberMe()

        def count1 = service.countBooks('Some Author')
        def count2 = service.countBooks('Another Author')

        assert service.countBooks('Some Author') == count1
        assert service.countBooks('Another Author') == count2
        assert service.amountOfCalls == 2
    }
}

class RememberMe {
    int amountOfCalls

    @Memoized
    int countBooks(String author) {
        amountOfCalls++
        return new Random().nextInt(10) //looking at DB
    }
}