package Task3.Part1;

import com.epam.Andriushchenko.Task3.Part1.MyUniqElemList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MyUniqElemListTest {
    private MyUniqElemList list;
    private ArrayList arrList;
    private static final Human INIT_HUMAN1 = new Human("Artur", 20);
    private static final Human INIT_HUMAN2 = new Human("Oleg", 18);
    private static final Human INIT_HUMAN3 = new Human("John", 15);
    private static final Human TEST_HUMAN1 = new Human("Artur", 20);
    private static final Human TEST_HUMAN2 = new Human("Oleg", 22);


    @BeforeEach
    void initList() {
        list = new MyUniqElemList();
        list.add(INIT_HUMAN1);
        list.add(INIT_HUMAN2);
        list.add(INIT_HUMAN3);
        arrList = new ArrayList();
    }

    @Test
    void shouldSetElemWhenElemNotExist() {
        assertEquals(INIT_HUMAN3, list.set(2, TEST_HUMAN2));
    }

    @Test
    void shouldThrowExceptionWhenElemExist() {
        assertThrows(IllegalArgumentException.class, () -> list.set(2, TEST_HUMAN1));
    }

    @Test
    void shouldAddElemWhenElemNotExist() {
        assertTrue(list.add(TEST_HUMAN2));
    }

    @Test
    void shouldThrowExceptionWhenAddExistElem() {
        assertThrows(IllegalArgumentException.class, () -> list.add(TEST_HUMAN1));
    }

    @Test
    void shouldAddElemToIndexWhenElemNotExist() {
        list.add(0, TEST_HUMAN2);

        assertEquals(list.get(0), TEST_HUMAN2);
    }

    @Test
    void shouldThrowExceptionWhenAddExistElemToIndex() {
        assertThrows(IllegalArgumentException.class, () -> list.add(2, INIT_HUMAN1));
    }

    @Test
    void shouldAddCollectionWhenElemNotExist() {
        arrList.add(TEST_HUMAN2);

        assertTrue(list.addAll(arrList));
    }

    @Test
    void shouldThrowExceptionWhenAddCollectionWithExistElemToIndex() {
        arrList.add(INIT_HUMAN1);

        assertThrows(IllegalArgumentException.class, () -> list.addAll(arrList));
    }

    @Test
    void shouldAddCollectionToIndexWhenElemNotExist() {
        arrList.add(TEST_HUMAN2);

        assertTrue(list.addAll(2, arrList));
    }

    @Test
    void shouldThrowExceptionWhenAddCollectionToIndexWithExistElemToIndex() {
        arrList.add(INIT_HUMAN1);

        assertThrows(IllegalArgumentException.class, () -> list.addAll(1, arrList));
    }
}
