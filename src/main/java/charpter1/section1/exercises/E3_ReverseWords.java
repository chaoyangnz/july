package charpter1.section1.exercises;

import org.junit.Test;

import static util.ArrayUtil.reverse;

/**
 * 3、单词翻转。输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变，句子中单词以空格符隔开。
 * 为简单起见，标点符号和普通字母一样处理。例如，输入“I am a student.”，则输出“student. a am I”。
 * ZYX = (X^t Y^t Z^t)^t
 */
public class E3_ReverseWords {

    public static void split(char[] chars, char sep) {
        final int N = chars.length;
        for(int i=0; i < N; ++i) {
            if(chars[i] != sep) {
                if((i+1 < N && chars[i+1] == sep) || (i-1 >=0 && chars[i-1] == sep)) {
                    System.out.println(i + " " + chars[i]);
                }
            }
        }
    }

    @Test
    public void test1() {
        char[] chars = "I am a student.".toCharArray();
        split(chars, ' ');
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
