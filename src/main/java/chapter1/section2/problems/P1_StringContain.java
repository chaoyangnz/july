package chapter1.section2.problems;

import org.junit.Test;

/**
 * 给定两个分别由字母组成的字符串A和字符串B，字符串B的长度比字符串A短。
 * 请问，如何最快地判断字符串B中所有字母是否都在字符串A里？
 */
public class P1_StringContain {

    public static boolean stringContains(String a, String b) {
        int bitmap = 0; // 0000000000 0000000000 00000000 00000000

        char[] aChars = a.toCharArray();
        for(int i=0; i < aChars.length; ++i) {
            bitmap |= 1 << aChars[i] - 'A';
        }

        char[] bChars = b.toCharArray();
        for(int i=0; i < bChars.length; ++i) {
            if((bitmap & 1 << bChars[i] - 'A') == 0) {
                return false;
            }
        }
        return true;
    }
    @Test
    public void test() {
        System.out.println(stringContains("ABCD", "BAD"));
        System.out.println(stringContains("ABCD", "BCE"));
    }
}
