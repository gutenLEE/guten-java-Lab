package algorithm;

import org.assertj.core.api.AbstractIntegerAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author gutenlee
 * @since 2022/05/24
 */
public class RomanToIntegerTest {

    HashMap<String, Integer> map;

    @BeforeEach
    void setUp() {
        map = new HashMap<>();
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);
    }

    private Integer getInteger(String roman) {

        if (roman.length() == 2) {
            String[] split = roman.split("");
            Integer a = map.get(split[0]);
            Integer b = map.get(split[1]);
            if (a < b)
                return b - a;
        }

        return map.get(roman);
    }

    private void assertRomanToInteger(String roman, int expected) {
        assertThat(getInteger(roman)).isEqualTo(expected);
    }

    @Test
    public void map_test() throws Exception {
        assertRomanToInteger("I", 1);
        assertRomanToInteger("V", 5);
    }

    @Test
    void largest_to_smallest() throws Exception {
        assertRomanToInteger("IV", 4);
        assertRomanToInteger("IX", 9);
    }





}
