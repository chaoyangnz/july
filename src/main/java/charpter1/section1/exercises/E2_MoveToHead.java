package charpter1.section1.exercises;

import charpter1.section1.problems.P1_RotateString;
import org.junit.Test;

/**
 * 2. 编写程序，在原字符串中把字符串尾部的m个字符移动到字符串的头部，要求：长度为n的字符串操作时间复杂度为O(n)，空间复杂度为O(1)。
 * 例如，原字符串为”Ilovebaofeng”，m=7，输出结果为：”baofengIlove”。
 * 同RotateString
 */
public class E2_MoveToHead {
    @Test
    public void test() {
        P1_RotateString rs = new P1_RotateString();
        String str = "Ilovebaofeng";
        rs.init(str.toCharArray());
        rs.rotate(str.length() - 7);
    }
}
