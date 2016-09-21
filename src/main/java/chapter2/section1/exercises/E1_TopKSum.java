package chapter2.section1.exercises;

import chapter2.section1.problems.P1_TopKMin;
import org.junit.Test;

import static util.ArrayUtil.print;

/**
 * 谷歌面试题：输入是两个整数数组，他们任意两个数的和又可以组成一个数组，求这个和中前k个数怎么做？
 */
public class E1_TopKSum {

    public static int[] selectTopKSum(int[] arr1, int[] arr2, int k) {
        final int M = arr1.length;
        final int N = arr2.length;
        int[] ints = new int[M * N];
        for(int i=0; i< M; ++i) {
            for(int j=0; j < N; ++j) {
                ints[i * N + j] = arr1[i] + arr2[j];
            }
        }

        return P1_TopKMin.selectTopKMin(ints, k);
    }

    @Test
    public void test() {
        int[] arr1 = {1, 2, 3};
        int[] arr2 = {4, 5, 6};

        print(selectTopKSum(arr1, arr2, 3));
    }
}
