package charpter1.section1.exercises;

import org.junit.Test;

/**
 * 3、单词翻转。输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变，句子中单词以空格符隔开。
 * 为简单起见，标点符号和普通字母一样处理。例如，输入“I am a student.”，则输出“student. a am I”。
 * ZYX = (X^t Y^t Z^t)^t
 */
public class E3_ReverseWords {
    private static void reverse(char[] chars, int from, int to) {
        while(from < to) {
            char temp = chars[from];
            chars[from++] = chars[to];
            chars[to--] = temp;
        }
    }

    private static void reverse(char[] chars) {
        reverse(chars, 0, chars.length-1);
    }

    public static String reverseWords(String str) {
        String[] words = str.split("\\s");
        StringBuilder sb = new StringBuilder(str.length());
        for(String word : words) {
            char[] chars = word.toCharArray();
            reverse(chars);
            sb.append(chars).append(" ");
        }
        sb.deleteCharAt(sb.length()-1);
        char[] strChars = sb.toString().toCharArray();
        reverse(strChars);
        return new String(strChars);
    }

    @Test
    public void test() {
        String str = "I am a student.";
        System.out.println(reverseWords(str));
    }
}
