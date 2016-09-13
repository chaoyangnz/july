package charpter1.section3.problems;

import org.junit.Test;

/**
 * 输入一个由数字组成的字符串，把它转换成整数并输出。例如：输入字符串"123"，输出整数123。
 * 给定函数原型int StrToInt(const char *str) ，实现字符串转换成整数的功能，不能使用库函数atoi。
 */
public class P1_StrToInt {
    public int atoi(char[] chars) {
        if(chars == null) {
            throw new IllegalArgumentException("input is null");
        }
        int result = 0;

        char leading = chars[0];
        boolean sign = true;
        if(leading == '-') {
            sign = false;
        } else if(leading == '+') {
            sign = true;
        } else if(isDigital(leading) && leading != '0') {
            result = leading - '0';
        } else {
            throw new IllegalArgumentException("illegal leading format");
        }
        for(int i = 1; i < chars.length; ++i) {
            char ch = chars[i];
            if(!isDigital(ch)) {
                throw new IllegalArgumentException("illegal digital char");
            }

            int digital = ch - '0';
            //handle overflow
            if(result > Integer.MAX_VALUE / 10 ||
              (sign && result == Integer.MAX_VALUE / 10 && digital > 7) ||
              (!sign && result == Integer.MAX_VALUE / 10 && digital > 8)) {
                throw new IllegalArgumentException("Overflow");
            }
            result = result * 10 + digital;
        }
        return sign ? result : -result;
    }

    private static boolean isDigital(char ch) {
        return ch >= '0' && ch <= '9';
    }

    @Test
    public void test() {
        System.out.println(String.format("max int: %d, min int: %d", Integer.MAX_VALUE, Integer.MIN_VALUE));
        char[] chars = {'1','2','3', '0','9'};
        System.out.println(atoi(chars));

        chars = new char[]{'-', '1','2','3', '0', '9'};
        System.out.println(atoi(chars));

        chars = new char[]{'2','1','4','7','4','8','3','6','4','7'};
        System.out.println(atoi(chars));

        chars = new char[]{'-','2','1','4','7','4','8','3','6','4','8'};
        System.out.println(atoi(chars));

//        chars = new char[]{'2','1','4','7','4','8','3','6','4','8'};
//        System.out.println(atoi(chars));

//        chars = new char[]{'-','2','1','4','7','4','8','3','6','4','9'};
//        System.out.println(atoi(chars));

        chars = new char[]{'0','2','1','4','7','4','8','3','6','4','9'};
        System.out.println(atoi(chars));
    }
}
