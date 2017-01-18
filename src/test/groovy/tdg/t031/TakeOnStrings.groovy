package tdg.t031

import spock.lang.Specification


/**
 * With method `take` on CharSequence you can take substring less or equal than given size easily
 */
class TakeOnStrings extends Specification {
    def "test"() {
        given:
        def shortString = '123'
        def longString = '1' * 100

        when:
        def taken = shortString.take(42)

        then:
        taken == '123'
        taken == shortString.substring(0, Math.min(4, shortString.length()))
        //                   ^^ Java way

        when:
        taken = longString.take(42)

        then:
        taken.length() == 42
    }
}