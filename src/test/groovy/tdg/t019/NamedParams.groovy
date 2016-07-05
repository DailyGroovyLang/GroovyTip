package tdg.t019

import spock.lang.Specification


class NamedParams extends Specification {
    Map methodWithMapArg(Map namedArgs) { return namedArgs }

    def "test"() {
        given: "Did you know than #groovylang converts named params to Map? #GroovyTip #GroovyDSL"

        def actual = methodWithMapArg(firstArg: '1', secondArg: 2)
        assert actual['firstArg'] == '1'
        assert actual['secondArg'] == 2
    }
}