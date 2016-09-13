package charpter1.section1.problems;

import org.junit.Test;

/**
 * 给定一个字符串，要求把字符串前面的若干个字符移动到字符串的尾部，如把字符串“abcdef”前面的2个字符'a'和'b'移动到字符串的尾部，
 * 使得原字符串变成字符串“cdefab”。请写一个函数完成此功能，要求对长度为n的字符串操作的时间复杂度为 O(n)，空间复杂度为 O(1)。
 * (XY)^t = Y^t X^t
 */
public class P1_RotateString {

    private char[] chars;

    public void init(char[] chars) {
        this.chars = chars;
    }

    private void reverse(int from, int to) {
        while(from < to) {
            char temp = chars[from];
            chars[from++] = chars[to];
            chars[to--] = temp;
        }
    }

    public void rotate(int m) {
        assert chars != null;

        int n = chars.length;
        m = n == 0 ? 0 : m % n;
        reverse(0, m-1);
        reverse(m, n-1);
        reverse(0, n-1);
        System.out.println(chars);
    }

    @Test
    public void test() {
        chars = new char[]{};
        rotate(2);

        chars = new char[]{'a'};
        rotate(2);

        chars = new char[]{'a', 'b'};
        rotate(2);

        chars = new char[]{'a', 'b', 'c'};
        rotate(2);

        chars = new char[]{'a', 'b', 'c', 'd'};
        rotate(2);

        chars = new char[]{'a', 'b', 'c', 'd', 'e'};
        rotate(2);
    }
}
