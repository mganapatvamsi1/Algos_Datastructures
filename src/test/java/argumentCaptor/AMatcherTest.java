package argumentCaptor;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;


@RunWith(MockitoJUnitRunner.class)
public class AMatcherTest {
    @InjectMocks
    private AMatcher aMatcher;
    @Mock
    private DataMatch dataMatch;
    @Captor
    private ArgumentCaptor<SomeData> argumentCaptor;

    @Before
    public void setUp() {
        aMatcher.test(dataMatch);
        aMatcher.secondTest(dataMatch);
        verify(dataMatch,times(1)).doSomething(argumentCaptor.capture());
    }

    @Test
    public void test() {
        SomeData actual = argumentCaptor.getValue();
        String expected = "Some test data";
        assertEquals(expected, actual.nothing());
    }

    @Test
    public void secondTest() {
        SomeData actual = argumentCaptor.getValue();
        String newExpected = "I am the happiest person in the world";
        assertEquals(newExpected, actual.dontKnow());
    }

}
