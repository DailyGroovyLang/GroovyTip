package tdg.t015;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import tdg.t015.BookService.Book;
import tdg.t015.BookService.Meta;
import tdg.t015.BookService.MetaProvider;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

public class SomeTest {

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Mock MetaProvider metaProviderMock;

    @Test
    public void test_that_book_is_created_correctly_based_on_the_given_meta()
            throws Exception {
        // given
        Meta meta = new Meta("John Doe", "John's Book", "1234567890123");
        when(metaProviderMock.getMeta(anyString())).thenReturn(meta);

        BookService service = new BookService(metaProviderMock);

        // when
        Book book = service.getBook("random isbn");

        // then
        assertThat(book, equalTo(new Book("John Doe", "John's Book", "1234567890123")));
    }
}
