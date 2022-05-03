package season1.t020

import spock.lang.Specification


class ArgsResolveOrder extends Specification {
    String method(Map namedArgs, int someArg, String... varArgs) {
        return "${namedArgs}|${someArg}|${varArgs}"
    }

    def "test"() {
        given: "Did you know that #groovylang resolves args in the following order: named args, usual args and varargs? #GroovyTip"

        assert method(3, 'hello', prop: 42, 'world', '!!!') == '[prop:42]|3|[hello, world, !!!]'
    }
}