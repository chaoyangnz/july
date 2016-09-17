package chapter2.section1.exercises;

import chapter2.section1.problems.P1_TopKMin;
import org.junit.Test;

import static util.ArrayUtil.*;

/**
 * Created by richard on 9/17/16.
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

        int heightTriangle = n + 1;
        int lengthTriangle = heightTriangle*(heightTriangle+1)/2; // n+1 is the height of upper triangle

        // candidates must be in the upper triangle
        int[] triangle = new int[lengthTriangle];
        int index = 0;
        for(int i = 0; i < heightTriangle; ++i) {
            for(int j=0 ; j <= i; ++j) {
                triangle[index++] = arr1[j] + arr2[i-j];
            }
        }

        if(lengthTriangle == k) return triangle;


        int toSelect = n + 1 + k - lengthTriangle;

        System.out.print("triangle: ");
        print(triangle);

        int[] candidates = subarraySuffix(triangle, lengthTriangle - heightTriangle); // n+1 elements
        System.out.print("tail candidates (need select " + toSelect + "): ");
        print(candidates);
        int[] remaining = P1_TopKMin.selectTopKMin(candidates, toSelect);
        System.arraycopy(remaining, 0, triangle, lengthTriangle - heightTriangle, toSelect);

        return subarrayPrefix(triangle, k-1);
    }

    @Test
    public void test() {
        int[] arr1 = {1, 3, 4, 8};
        int[] arr2 = {2, 4, 5, 9};

        print(selectTopKSum(arr1, arr2, 8));
    }
}
