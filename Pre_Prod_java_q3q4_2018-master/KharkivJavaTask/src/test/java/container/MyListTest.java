package container;

import com.epam.Andriushchenko.Task1.container.MyList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MyListTest {
    private MyList list;
    private static final int FIRST_INDEX = 0;
    private static final String INIT_STR1 = "1";
    private static final String INIT_STR2 = "2";
    private static final String INIT_STR3 = "3";
    private static final String TEST_STR1 = "4";
    private static final String TEST_STR2 = "5";

    @Test
    void shouldAddElemToEnd() {
        int oldLength = list.size();

        list.add(TEST_STR1);

        assertEquals(TEST_STR1, list.get(list.size() - 1));
        assertEquals(oldLength + 1, list.size());
    }

    @Test
    void shouldAddElemToIndex() {
        list.add(0, TEST_STR1);

        assertEquals(TEST_STR1, list.get(FIRST_INDEX));
    }

    @Test
    void shouldThrowExWhenAddToIndexNotValid() {
        assertThrows(IndexOutOfBoundsException.class, () -> list.add(list.size(), TEST_STR1));
        assertThrows(IndexOutOfBoundsException.class, () -> list.add(FIRST_INDEX - 1, TEST_STR2));
    }

    @Test
    void shouldReturnElemByIndex() {
        assertEquals(INIT_STR1, list.get(FIRST_INDEX));
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(FIRST_INDEX - 1));
    }

    @Test
    void shouldRemoveElemByIndex() {
        assertEquals(INIT_STR1, list.remove(FIRST_INDEX));
    }

    @Test
    void shouldThrowExWhenRemoveIndexNotValid() {
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(list.size()));
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(FIRST_INDEX - 1));
    }

    @Test
    void shouldRemoveElemetWhenExist() {
        list.remove(INIT_STR1);

        assertEquals(INIT_STR2, list.get(FIRST_INDEX));
    }

    @BeforeEach
    public void initList() {
        list = new MyList();
        list.add(INIT_STR1);
        list.add(INIT_STR2);
        list.add(INIT_STR3);
    }
}