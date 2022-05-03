package season1.t030

import spock.lang.Specification


/**
 * When you need to split string by some characters try Groovy tokenize instead of String split
 */
class StringTokenize extends Specification {
    def "test"() {
        given:
        def greeting = 'Hello, Groovy People'

        when:
        def tokens = greeting.tokenize(' ,')
        //                              ^^ set of delimiters

        then:
        tokens == ['Hello', 'Groovy', 'People']
        tokens == greeting.split(/(,| )/).findAll()
        //                  regexp ^^      ^^ filter of empty tokens
    }
}