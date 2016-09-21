package chapter2.section6.problems;

import org.junit.Test;
import util.ArrayUtil;

/**
 * 输入一个整数数组，调整数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。要求时间复杂度为O(n)。
 */
public class P1_ReorderOddEven {

    public static void reorderOddEven(int[] ints) {
        final int N = ints.length;
        int i = -1; // before this index, all odd -> 挡板
        int j = 0; // current index
        while(j < N && i < j) {
            if(ints[j] % 2 == 1) { // even, need to move rightward the 挡板
                i++;
                ArrayUtil.swap(ints, i, j);
            }
            j++;
        }

//        for(int i =0; i < N; ++i) {
//            if(ints[i] % 2 == 0) { // even
//                int j = i+1;
//                for(; j < N; ++j) { // scan after odd to swap
//                    if(ints[j] % 2 != 0) { // odd
//                        ArrayUtil.swap(ints, i, j); break;
//                    }
//                }
//                if(j == N-1) break;
//            }
//        }
    }

    @Test
    public void test() {
        int[] ints = {1, 2, 4, 5, 6, 8};
        reorderOddEven(ints);
        ArrayUtil.print(ints);
        int[] ints1 = {2, 8, 7, 1, 3, 5, 6, 4};
        reorderOddEven(ints1);
        ArrayUtil.print(ints1);
    }
}
