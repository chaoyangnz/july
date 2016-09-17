package chapter1.section4.exercises;

import chapter1.section4.problems.P1_Palindrome;
import org.junit.Test;

import java.util.Stack;

/**
 * Created by riyang on 9/14/16.
 */
public class E2_StackPalindrome {

    private P1_Palindrome p = new P1_Palindrome();

    public boolean isPalindrome(Stack<Character> stack) {
        char[] chars = new char[stack.size()];
        int i = 0;
        while (!stack.empty()) {
            chars[i++] = stack.pop();
        }

        return p.isPalindrome(chars);
    }

    @Test
    public void test() {
        Stack<Character> stack = new Stack<Character>();
        stack.push('m');
        stack.push('a');
        stack.push('d');
        stack.push('a');
        stack.push('m');

        System.out.println(isPalindrome(stack));

        stack = new Stack<Character>();
        stack.push('m');
        stack.push('a');
        stack.push('d');
        stack.push('a');
        stack.push('b');

        System.out.println(isPalindrome(stack));
    }
}
