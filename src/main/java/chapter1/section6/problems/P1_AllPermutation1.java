package chapter1.section6.problems;

import org.junit.Test;

import static util.ArrayUtil.*;

/**
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 * 例如输入字符串abc，则输出由字符a、b、c 所能排列出来的所有字符串
 * abc、acb、bac、bca、cab 和 cba。
 */
public class P1_AllPermutation1 {

    private static boolean nextPermutation(char[] perm) {
        final int N = perm.length;

        //①找到排列中最后（最右）一个升序的首位位置i，x = ai
        int i = N-2;
        while(i >= 0 && perm[i] >= perm[i+1]) {
            --i;
        }

        if(i < 0) return false;

        //②找到排列中第i位右边最后一个比ai 大的位置j，y = aj
        int k = N-1;
        while(k > i && perm[k] <= perm[i]) {
            --k;
        }

        //③交换x，y
        swap(perm, i, k);

        //④把第(i+ 1)位到最后的部分翻转
        reverse(perm, i+1, N-1);
        return true;
    }

    public static void calcAllPermutation(char[] chars) {

        do {
            System.out.println(chars);
        } while (nextPermutation(chars));
    }

    @Test
    public void test() {
        char[] chars = {'a', 'b', 'c', 'd', 'e'};
        calcAllPermutation(chars);
    }
}
