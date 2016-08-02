package tdg.t025

import spock.lang.Specification


class DynamicMethodInRuntime extends Specification {
    public void growLeftPadMethod(def o) {
        o.metaClass.leftPad = { def length = 0 ->
            delegate.toString().padLeft(length, '_')
        }
    }

    def "test"() {
        given: "What if you want to extend your object with new behaviour? ExpandoMetaClass can do this! #groovylang #GroovyTip"
        def number = 1
        growLeftPadMethod(number)

        def str = 'str'
        growLeftPadMethod(str)

        def object = new Tuple()
        growLeftPadMethod(object)

        number.leftPad(5) == '____1'
        str.leftPad(5) == '__str'
        object.leftPad(5) == '___[]'
    }
}