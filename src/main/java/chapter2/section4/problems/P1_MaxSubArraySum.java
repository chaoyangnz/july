package chapter2.section4.problems;

import org.junit.Test;
import util.ArrayUtil;

/**
 * Created by richard on 9/21/16.
 */
public class P1_MaxSubArraySum {

    public int[] findMaxSubArraySum(int[] ints) {
        int[] prefixSum = new int[ints.length];
        int i = 0;

        // compute prefix sum, at the same time get its max and min
        int maxPrefixSumIndex = 0;
        int minPrefixSumIndex = 0;
        while(i < ints.length) {
            prefixSum[i] = i == 0 ? ints[i] : prefixSum[i-1] + ints[i];

            if(prefixSum[i] > prefixSum[maxPrefixSumIndex]) maxPrefixSumIndex = i;
            if(prefixSum[i] < prefixSum[minPrefixSumIndex]) minPrefixSumIndex = i;

            ++i;
        }

        // so the final array should be the range between the max and min of the prefix sum
        int from = Math.min(maxPrefixSumIndex, minPrefixSumIndex) + 1;
        int lenth = Math.abs(maxPrefixSumIndex - minPrefixSumIndex);

        int[] subarr = new int[lenth];
        System.arraycopy(ints, from, subarr, 0, lenth);
        return subarr;
    }

    @Test
    public void test() {
        int[] ints = {1, -2, 3, 10, -4, 7, 2, -5};
        ArrayUtil.print(findMaxSubArraySum(ints));
    }
}
