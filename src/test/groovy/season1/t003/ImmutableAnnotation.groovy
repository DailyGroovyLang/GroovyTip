package season1.t003

import spock.lang.Specification


class ImmutableAnnotation extends Specification {
    def "test"() {
        given: "Like #kotlin data classes? Try Groovy @Immutable which adds the necessary getters, constructors, equals, hashCode and other helper methods"
        //new DataClass('name') //compile error
        assert new DataClass('name', 42L) == new DataClass('name', 42L)
    }
}

@groovy.transform.Immutable
class DataClass {
    String name;
    long value;
}