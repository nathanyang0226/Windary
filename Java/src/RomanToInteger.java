import java.util.HashMap;
import java.util.Map;

/**
 * Given a roman numeral, convert it to an integer.
 * Input is guaranteed to be within the range from 1 to 3999.
 * <p>
 * Accepted.
 */
public class RomanToInteger {

    public int romanToInt(String s) {
        if (s == null) {
            return -1;
        }

        Map<Character, Integer> dict = new HashMap<>(7);
        dict.put('I', 1);
        dict.put('V', 5);
        dict.put('X', 10);
        dict.put('L', 50);
        dict.put('C', 100);
        dict.put('D', 500);
        dict.put('M', 1000);

        char[] chars = s.toCharArray();
        int result = 0;

        for (int i = 0; i < chars.length; i++) {
            if (i + 1 < chars.length
                    && dict.get(chars[i + 1]) > dict.get(chars[i])
                    && (chars[i] == 'I' || chars[i] == 'X' || chars[i] == 'C')) {
                result += dict.get(chars[i + 1]) - dict.get(chars[i]);

                i++;
            } else {
                result += dict.get(chars[i]);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        RomanToInteger rtt = new RomanToInteger();
        // Expected: 621 = 500 + 100 + 10 + 10 +1
        System.out.println(rtt.romanToInt("DCXXI"));
        // Expected: 1996 = 1000 - (100 - 1000) - (10 - 100) + 5 + 1
        System.out.println(rtt.romanToInt("MCMXCVI"));
        // Expected: 999 = - (100 - 1000) - (10 - 100) - (1 - 10)
        System.out.println(rtt.romanToInt("CMXCIX"));
    }

}
