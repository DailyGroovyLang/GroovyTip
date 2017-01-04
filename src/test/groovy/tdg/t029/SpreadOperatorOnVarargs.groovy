package tdg.t029

import spock.lang.Specification

/**
 * If you need to spread you list among method params, use spread operator. So obvious (⌐■_■) #GroovyTip
 */
class SpreadOperatorOnVarargs extends Specification {

    def withVarargParam(String... strings) {
        return strings;
    }

    def "test"() {
        given:
        def list = ['a', 'b', 'c']

        expect:
        withVarargParam(*list) == withVarargParam('a', 'b', 'c')
        and:
        Arrays.equals(withVarargParam(*list), ['a', 'b', 'c'].toArray())
    }
}