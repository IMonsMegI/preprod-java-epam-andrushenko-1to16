package Task3.Part2;

import com.epam.Andriushchenko.Task3.Part2.FirstStrHashCode;
import com.epam.Andriushchenko.Task3.Part2.SecondStrHashCode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class HashMapTest {
    private HashMap hashMap;
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
        hashMap = new HashMap();
        hashMap.put(firstStr1, firstStrHash1);
        hashMap.put(firstStr2, firstStrHash2);
        hashMap.put(secondStr1, secondStrHash1);
        hashMap.put(secondStr2, secondStrHash2);
        iterator = hashMap.entrySet().iterator();
    }

    @Test
    void shouldReturnSizeOfHashMap() {
        assertEquals(4, hashMap.size());
    }

    @Test
    void shouldReturnElemsOfHashMap() {
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator.next();
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }
}
