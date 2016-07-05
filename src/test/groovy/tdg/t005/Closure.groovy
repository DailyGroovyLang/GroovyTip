package tdg.t005

import spock.lang.Specification


class Closure extends Specification {
    def "test"() {
        given: "Like Java8 lambdas? Try their elder brother - Closure! #GroovyTip #groovylang"

        assert 3L == ['1', '2', '3']
                .stream() // we know it's java way ;)
                .map(Long.&valueOf) // .map(Long::valueOf)
                .filter { it > 2 }  // .filter(it -> it > 2)
                .findAny().get()    // just to show that Groovy <3 Java
    }
}