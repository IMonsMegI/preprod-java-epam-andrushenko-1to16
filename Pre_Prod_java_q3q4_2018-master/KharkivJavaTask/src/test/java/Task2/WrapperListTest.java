package Task2;

import com.epam.Andriushchenko.Task2.Part2.UnmodifierCollectionException;
import com.epam.Andriushchenko.Task2.Part2.WrapperList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class WrapperListTest {
    private WrapperList wrapperList;
    private List listUnmod;
    private List listMod;
    private static final String INIT_UNMOD_STR_1 = "1";
    private static final String INIT_MOD_STR_2 = "2";
    private static final String INIT_MOD_STR_3 = "3";
    private static final String TEST_STR = "test";

    @BeforeEach
    void initWrapper() {
        listUnmod = new ArrayList();
        listMod = new ArrayList();
        listUnmod.add(INIT_UNMOD_STR_1);
        listMod.add(INIT_MOD_STR_2);
        listMod.add(INIT_MOD_STR_3);
        wrapperList = new WrapperList(listUnmod, listMod);
    }

    @Test
    void shouldReturnSummOfUnmodAndModListSizes() {
        assertEquals(listUnmod.size() + listMod.size(), wrapperList.size());
    }

    @Test
    void shouldAddElemToEndOfWrapper() {
        wrapperList.add(TEST_STR);

        assertEquals(TEST_STR, wrapperList.get(wrapperList.size() - 1));
    }

    @Test
    void shouldAddElemToIndexWhenIndexIsValid() {
        wrapperList.add(1, TEST_STR);

        assertEquals(TEST_STR, wrapperList.get(1));
    }

    @Test
    void shouldRemoveExistElemWhenElemInModPart() {
        assertTrue(wrapperList.remove(INIT_MOD_STR_2));
    }

    @Test
    void shouldThrowExceptionWhenRemoveElemFromUnmodPart() {
        assertThrows(UnmodifierCollectionException.class, () -> wrapperList.remove(INIT_UNMOD_STR_1));
    }

    @Test
    void shouldRemoveElemWhenIndexValid() {
        assertEquals(INIT_MOD_STR_3, wrapperList.remove(wrapperList.size() - 1));
    }

    @Test
    void shouldThrowExceptionWhenRemoveElemAndIndexNotValid() {
        assertThrows(UnmodifierCollectionException.class, () -> wrapperList.remove(0));
    }

    @Test
    void shouldSetElemWhenIndexValid() {
        wrapperList.set(2, TEST_STR);

        assertEquals(TEST_STR, wrapperList.get(wrapperList.size() - 1));
    }

    @Test
    void shouldThrowExceptionWhenIndexNotValid() {
        assertThrows(UnmodifierCollectionException.class, () -> wrapperList.set(0, TEST_STR));
    }

    @Test
    void shouldReturnIndexOfElem() {
        assertEquals(wrapperList.size() - 1, wrapperList.indexOf(INIT_MOD_STR_3));
    }
}
