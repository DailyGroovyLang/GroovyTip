package season1.t028

import spock.lang.Specification

class SlashyString extends Specification {
    def "test"() {
        given: "Try slashy strings to avoid extra-escaping of backslashes in regex. #groovylang #GroovyTip"

        assert '\\d+' == /\d+/
        // or $/../$ for regex with slashes
        assert '\\w/' == $/\w//$
    }
}
