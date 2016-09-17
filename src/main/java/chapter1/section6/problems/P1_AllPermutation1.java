package chapter1.section6.problems;

import org.junit.Test;

import static util.ArrayUtil.*;

/**
 * Created by riyang on 9/14/16.
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
