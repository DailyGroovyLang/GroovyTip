package season1.t023

import spock.lang.Specification

import java.beans.Introspector

class ClosureComposition extends Specification {
    def "test"() {
        given: "Try Closure Composition for chaining calls. #groovylang #GroovyTip"

        def toTitleCase = { String[] array -> array.collect { it[0].toUpperCase() + it.substring(1) } }
        def splitByUnderscore = { String s -> s.split('_') }
        def join = { List<String> array -> array.join('') }
        def decapitalize = Introspector.&decapitalize

        def toCamelCase = splitByUnderscore >> toTitleCase >> join >> decapitalize

        assert toCamelCase('python_case') == 'pythonCase'
    }
}