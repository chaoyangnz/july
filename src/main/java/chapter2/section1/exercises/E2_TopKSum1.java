package chapter2.section1.exercises;

import chapter2.section1.problems.P1_TopKMin;
import org.junit.Test;

import static util.ArrayUtil.*;

/**
 * 有两个序列A和B,A=(a1,a2,...,ak),B=(b1,b2,...,bk)，A和B都按升序排列。对于1<=i,j<=k，求k个最小的（ai+bj）。要求算法尽量高效。
 */
public class E2_TopKSum1 {

    public static int[] selectTopKSum(int[] arr1, int[] arr2, int k) {
        final int M = arr1.length;
        final int N = arr2.length;
        assert M == N;
        assert k < N*N;

        int n = 0;
        while ((n+1)*(n+2)/2 < k) {
            ++n;
        }

        int height = n + 1; // the height of upper triangle
        int area = height*(height+1)/2; // area is total count of upper triangle

        // candidates must be in the upper triangle
        int[] triangle = new int[area];
        int index = 0;
        for(int h = 0; h < height; ++h) {
            for(int i=0 ; i <= h; ++i) {
                triangle[index++] = arr1[i] + arr2[h-i];
            }
        }

        if(area == k) return triangle;

        int toSelect = k - (area - height);

        System.out.print("triangle: ");
        print(triangle);

        int[] candidates = subarraySuffix(triangle, area - height); // n+1 elements: from area - height -1  + 1
        System.out.print("tail candidates (need select " + toSelect + "): ");
        print(candidates);
        int[] remaining = P1_TopKMin.selectTopKMin(candidates, toSelect);
        System.arraycopy(remaining, 0, triangle, area - height, toSelect);

        return subarrayPrefix(triangle, k-1);
    }

    @Test
    public void test() {
        int[] arr1 = {1, 3, 4, 8};
        int[] arr2 = {2, 4, 5, 9};

        print(selectTopKSum(arr1, arr2, 9));
    }
}
