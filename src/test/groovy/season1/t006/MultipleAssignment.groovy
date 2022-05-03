package season1.t006

import spock.lang.Specification

class MultipleAssignment extends Specification {
    def "test"() {
        given: "Try 'Multiple assignment' feature. #GroovyTip #groovylang"

        // here is how it works
        def (int42, str42) = [42, '42'] // def int42 = 42, str42 = '42'
        assert int42 == Integer.valueOf(str42)

        // or really valuable case
        def (strs, ints) = ['1', 2, '3', '4', 5, '#GroovyTip']
                .split { it instanceof String }

        assert strs == ['1', '3', '4', '#GroovyTip']
        assert ints == [2, 5]
    }
}
