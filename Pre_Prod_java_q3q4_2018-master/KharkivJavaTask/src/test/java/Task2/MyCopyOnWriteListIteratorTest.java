package Task2;

import com.epam.Andriushchenko.Task2.Part1.MyCopyOnWriteList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MyCopyOnWriteListIteratorTest {
    private MyCopyOnWriteList list;
    private static final String INIT_STR1 = "1";
    private static final String INIT_STR2 = "2";
    private static final String TEST_STR = "test";
    private Iterator iterator;

    @BeforeEach
    void initList() {
        list = new MyCopyOnWriteList();
        list.add(INIT_STR1);
        list.add(INIT_STR2);
        iterator = list.iterator();
    }

    @Test
    void shouldThrowExceptionIfElemNotExistWhenNextCalled() {
        list.remove(INIT_STR2);
        iterator.next();
        iterator.next();

        assertThrows(NoSuchElementException.class, () -> iterator.next());
    }

    @Test
    void shouldReturnElemIfExistWhenNextCalled() {
        list.add(TEST_STR);

        assertEquals(INIT_STR1, iterator.next());
    }
}
