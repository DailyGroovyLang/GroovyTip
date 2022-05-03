package season1.t014

import spock.lang.Specification

import java.time.LocalDate


class Categories extends Specification {
    def "test"() {
        given: "Continue to improve your DSL with Groovy Categories! #GroovyTip #groovylang"

        // Pharmacy is annotated with @Category(Number)
        use(Pharmacy) {
            // equivalent to: take(Pharmacy.pills(3))
            PillsDsl.take 3.pills()
        }

        // and it works with static methods
        use(LocalDate) {
            assert '1970-01-01'.parse() == LocalDate.of(1970, 1, 1)
        }
    }
}

@Category(Number)
class Pharmacy {
    def pills(Number n) {
        return new Pills(this)
    }
}

class Pills {
    Number pills

    Pills(Number pills) {
        this.pills = pills
    }
}

class PillsDsl {
    static def take(Pills pills) {
        return pills.pills
    }
}