package tdg.t015

import spock.lang.Specification
import tdg.t015.BookService.Book

import static tdg.t015.BookService.Meta
import static tdg.t015.BookService.MetaProvider

//  Still using jUnit/TestNG? Try Spock Framework; #GroovyTool #GroovyTip @SpockFramework
class SomeSpec extends Specification {
    def "book should be created correctly based on the given meta"() {
        given:
        def metaProviderMock = Mock(MetaProvider) {
            getMeta(_ as String) >> { args ->
                new Meta('John Doe', "John's Book", args[0]);
            }
        }

        def service = new BookService(metaProviderMock);

        when:
        def book = service.getBook('random isbn');

        then:
        book == new Book('John Doe', "John's Book", 'random isbn')
    }
}
