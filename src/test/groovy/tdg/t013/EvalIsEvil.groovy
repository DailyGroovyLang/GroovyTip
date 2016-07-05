package tdg.t013

import spock.lang.Specification

class EvalIsEvil extends Specification {
    def "test"() {
        given: "13th special tweet ;) Use cautiously! #GroovyTip #groovylang"
        def thirteenLittleImps = Eval.xyz 13, ']:>', ' ', ' (y + z) * x '

        assert thirteenLittleImps == ']:> ]:> ]:> ]:> ]:> ]:> ]:> ]:> ]:> ]:> ]:> ]:> ]:> '
    }
}