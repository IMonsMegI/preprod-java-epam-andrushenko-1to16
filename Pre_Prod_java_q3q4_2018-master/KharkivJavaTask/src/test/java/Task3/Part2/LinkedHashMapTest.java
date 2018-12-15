package Task3.Part2;

import com.epam.Andriushchenko.Task3.Part2.FirstStrHashCode;
import com.epam.Andriushchenko.Task3.Part2.SecondStrHashCode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class LinkedHashMapTest {
    private LinkedHashMap linkedHashMap;
    private Iterator iterator;
    private FirstStrHashCode firstStr1 = new FirstStrHashCode("asdf");
    private FirstStrHashCode firstStr2 = new FirstStrHashCode("qwertyqwe");
    private SecondStrHashCode secondStr1 = new SecondStrHashCode("abcdefg");
    private SecondStrHashCode secondStr2 = new SecondStrHashCode("oprst");

    private Integer firstStrHash1 = new Integer(firstStr1.hashCode());
    private Integer firstStrHash2 = new Integer(firstStr2.hashCode());
    private Integer secondStrHash1 = new Integer(secondStr1.hashCode());
    private Integer secondStrHash2 = new Integer(secondStr2.hashCode());

    @BeforeEach
    void initHashMap() {
        linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(firstStr1, firstStrHash1);
        linkedHashMap.put(firstStr2, firstStrHash2);
        linkedHashMap.put(secondStr1, secondStrHash1);
        linkedHashMap.put(secondStr2, secondStrHash2);
        iterator = linkedHashMap.entrySet().iterator();
    }

    @Test
    void shouldReturnSizeOfHashMap() {
        assertEquals(4, linkedHashMap.size());
    }

    @Test
    void shouldReturnElementsInAddWay() {
        Map.Entry entry = (Map.Entry) iterator.next();
        assertEquals(firstStrHash1, entry.getValue());
        entry = (Map.Entry) iterator.next();
        entry = (Map.Entry) iterator.next();
        assertEquals(secondStrHash1, entry.getValue());
    }
}