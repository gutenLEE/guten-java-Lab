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

        String[] split = roman.split("");
        int sum = 0;
        for (String str : split) {
            sum += map.get(str);
        }
        return sum;
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
    @DisplayName("로만 문자 길이가 2 이고, 첫번째 로만 문자의 값이 두번째보다 작을 경우")
    void if_length_2_() throws Exception {
        assertRomanToInteger("IV", 4);
        assertRomanToInteger("IX", 9);

        assertRomanToInteger("XL", 40);
        assertRomanToInteger("XC", 90);

        assertRomanToInteger("CD", 400);
        assertRomanToInteger("CM", 900);

    }

    @Test
    void largest_to_smallest() throws Exception {
         assertRomanToInteger("LVIII", 58);
         assertRomanToInteger("MCMXCIV", 1994);
    }







}
