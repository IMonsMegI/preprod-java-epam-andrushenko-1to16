package container;

import com.epam.Andriushchenko.Task1.container.MyList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PredicateIteratorTest {
    private MyList list;
    private static final String INIT_STR1 = "1";
    private static final String INIT_STR2 = "2";

    @BeforeEach
    void initList() {
        list = new MyList();
    }

    @Test
    void shouldReturnFalseWhenHasNextCalledOnEmptyCollection() {
        Iterator it = list.iterator();

        assertFalse(it.hasNext());
    }

    @Test
    void shouldThrowExWhenNextCalledOnEmptyCollection() {
        Iterator it = list.iterator();

        assertThrows(NoSuchElementException.class, () -> it.next());
    }

    @Test
    void shouldAlwaysReturnTrueWhenHasNextCalledOnSingleElemCollection() {
        Iterator it = list.iterator();

        list.add(INIT_STR1);

        for (int i = 0; i < 10; i++) {
            assertTrue(it.hasNext());
        }
    }

    @Test
    void shouldReturnElemWhenNextCalledWhileElemExist() {
        list.add(INIT_STR1);
        list.add(INIT_STR2);
        Iterator iterator = list.iterator();

        assertEquals(INIT_STR1, iterator.next());
        assertEquals(INIT_STR2, iterator.next());
    }

    @Test
    void shouldReturnTrueWhenHasNextFindElemByPredicate() {
        Predicate predicate = (Object o) -> "2".equals(o);

        list.add(INIT_STR1);
        list.add(INIT_STR2);
        Iterator iterator = list.iterator(predicate);

        assertTrue(iterator.hasNext());
    }

    @Test
    void shouldReturnElemWhenNextFindElemByPredicate() {
        Predicate predicate = (Object o) -> "2".equals(o);
        list.add(INIT_STR1);
        list.add(INIT_STR2);
        Iterator iterator = list.iterator(predicate);

        assertEquals(INIT_STR2, iterator.next());
    }
}
