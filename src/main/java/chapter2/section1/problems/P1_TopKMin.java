package chapter2.section1.problems;

import org.junit.Test;
import util.Heap;

import static util.ArrayUtil.print;

/**
 * Created by richard on 9/17/16.
 */
public class P1_TopKMin {

    public int[] selectTopKMin(int[] ints, int k) {
        Heap heap = new Heap();
        for(int i=0; i < ints.length; ++i) {
            if(i < k) { // first k number, just add
                heap.offer(ints[i]);
            } else {
                if(ints[i] < heap.peek()) { // if greater than the max of top k minimum
                    heap.poll();
                    heap.offer(ints[i]);
                }
            }
        }

        return heap.toArray();
    }

    @Test
    public void test() {
        int[] ints = {2, 3, 14, 9, 29, 37, 13, 27, 8, 10, 15, -1};
        print(selectTopKMin(ints, 5));
    }
}
