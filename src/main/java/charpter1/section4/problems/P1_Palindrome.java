package charpter1.section4.problems;

import org.junit.Test;

/**
 * 回文，英文palindrome，指一个顺着读和反过来读都一样的字符串，比如madam、我爱我，这样的短句在智力性、趣味性和艺术性上都颇有特色，中国历史上还有很多有趣的回文诗。
 */
public class P1_Palindrome {

    public boolean isPalindrome(char[] chars) {
        if(chars == null) return false;

        int i = 0;
        int j = chars.length - 1;
        while(i < j) {
            if(chars[i] != chars[j]) {
                return false;
            } else {
                ++i;
                --j;
            }
        }
        return true;
    }

    @Test
    public void test() {
        char[] chars = "madam".toCharArray();
        System.out.println(isPalindrome(chars));
    }
}
