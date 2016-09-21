package chapter2.section2.problems;

import org.junit.Test;
import util.ArrayUtil;
import util.BitsetUtil;

/**
 * 输入一个数组和一个数字，在数组中查找两个数，使得它们的和正好是输入的那个数字。
 * 要求时间复杂度是O(N)。如果有多对数字的和等于输入的数字，输出任意一对即可。
 * 例如输入数组1、2、4、7、11、15和数字15。由于4+11=15，因此输出4和11。
 */
public class P1_Decomposition {
    public static int[] decomposite(int[] ints, int sum) {
        final int max = ArrayUtil.max(ints);
        final int size = max%32 == 0 ? max/32 : (max/32+1);
        int[] bitset = new int[size];
        for(int i=0; i < ints.length; ++i) { // O(N)
            BitsetUtil.set(bitset, ints[i]);
        }
        int[] ret = new int[2];

        for(int i = 0; i < ints.length; ++i) { // O(N)
            if(BitsetUtil.get(bitset, sum - ints[i])) {
                ret[0] = ints[i];
                ret[1] = sum - ints[i];
                for(int j=i; j < ints.length; ++j) {
                    if(ints[j] == ret[1]) {
                        System.out.println(String.format("index: %d %d", i, j));
                    }
                }
                return ret;
            }
        }



        return null;
    }

    @Test
    public void test() {
        int[] ints = {1, 2, 4, 7, 11, 15};
        ArrayUtil.print(decomposite(ints, 15));
    }
}
