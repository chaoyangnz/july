package chapter1.section1.exercises;

import org.junit.Test;

import static util.ArrayUtil.*;

/**
 * 3、单词翻转。输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变，句子中单词以空格符隔开。
 * 为简单起见，标点符号和普通字母一样处理。例如，输入“I am a student.”，则输出“student. a am I”。
 * ZYX = (X^t Y^t Z^t)^t
 */
public class E3_ReverseWords {

    public static void reverseWords(char[] chars) {
        Range[] ranges = split(chars, ' ');
        for(Range range : ranges) {
            reverse(chars, range.from, range.to);
        }
        reverse(chars);
    }

    @Test
    public void test() {
        char[] str = "I am a student.".toCharArray();
        reverseWords(str);
        System.out.println(str);
    }
}
