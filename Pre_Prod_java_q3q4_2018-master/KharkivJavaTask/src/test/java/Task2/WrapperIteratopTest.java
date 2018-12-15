package Task2;

import com.epam.Andriushchenko.Task2.Part2.WrapperList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.*;

public class WrapperIteratopTest {
    private WrapperList wrapperList;
    private Iterator iterator;
    private List listUnmod;
    private List listMod;
    private static final String INIT_UNMOD_STR_1 = "1";
    private static final String INIT_MOD_STR_2 = "2";
    private static final String INIT_MOD_STR_3 = "3";

    @BeforeEach
    void initWrapper() {
        listUnmod = new ArrayList();
        listMod = new ArrayList();
        listUnmod.add(INIT_UNMOD_STR_1);
        listMod.add(INIT_MOD_STR_2);
        listMod.add(INIT_MOD_STR_3);
        wrapperList = new WrapperList(listUnmod, listMod);
        iterator = wrapperList.iterator();
    }

    @Test
    void shouldReturnElemWhenNextCalledWhileElemExist() {
        assertEquals(INIT_UNMOD_STR_1, iterator.next());
        assertEquals(INIT_MOD_STR_2, iterator.next());
        assertEquals(INIT_MOD_STR_3, iterator.next());
    }

    @Test
    void shouldReturnTrueWhileHasNextElem() {
        assertTrue(iterator.hasNext());
        iterator.next();
        assertTrue(iterator.hasNext());
        iterator.next();
        assertTrue(iterator.hasNext());
        iterator.next();
        assertFalse( iterator.hasNext());
    }
}
