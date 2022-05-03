package season1.t004

import spock.lang.Specification


class SpaceshipOperator extends Specification {
    def "test"() {
        given: "Try the cool Spaceship operator syntax instead of .compareTo(T)"
        assert (2 <=> 1) > 0
        assert (1 <=> 1) == 0

        assert ('a' <=> 'z') < 0
        assert 'a'.compareTo('z') < 0
    }
}