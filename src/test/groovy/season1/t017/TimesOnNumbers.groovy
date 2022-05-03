package season1.t017

import spock.lang.Specification


class TimesOnNumbers extends Specification {
    def "test"() {
        given: "Need `for` loop with index? Try Number#times(Closure) #GroovyTip #groovylang"

        3.times { print "$it " } // 0 1 2

        // instead of
        for (def i = 0; i < 3; i++) {
            print "$i "
        }
    }

    def "re01"() {
        given:
        "Q: can I use break inside times?" +
                "A: if you look at the implementation you can see that .times(C) checks Closure Directive, so such case also possible:"
        3.times {
            print "$it ";
            if (it == 1) {
                // but version with ranges is better
                directive = Closure.DONE
            }
        } // 0 1
    }
}