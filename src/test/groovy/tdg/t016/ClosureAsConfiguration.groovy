package tdg.t016

import spock.lang.Specification


class ClosureAsConfiguration extends Specification {
    def "test"() {
        given: "Creating programmatic configuration, don't forget about Closures and Delegates #GroovyTip #groovylang"
        def configured = new Configurable({ c2 = 'value from configuration' })
        //                                  ^^ of course with code completion (⌐■_■)
        assert configured.c1 == 'default value'
        assert configured.c2 == 'value from configuration'
    }
}

class Configurable {
    @Delegate Config config

    static class Config {
        String c1 = 'default value'
        String c2
    }

    Configurable(@DelegatesTo(Config) Closure configuration) {
        (this.config = new Config()).with configuration
    }
}