package util;

import org.junit.Test;

import java.util.Arrays;

import static util.ArrayUtil.*;

/**
 * A maximum heap
 */
public class Heap {
    private int[] arr = new int[1]; // first is dummy
    public boolean log = false;

    public int[] toArray() {
        return subarraySuffix(arr, 1);
    }

    private void resize(int i) {
        int[] arr1 = new int[arr.length+i];
        System.arraycopy(arr, 0, arr1, 0, i > 0 ? arr.length : arr1.length);
        arr = arr1;
    }

    /**
     * Add a num to the last of the complete binary tree, then float upward until the highest layer.
     *
     * @param num
     */
    public void offer(int num) {
        resize(1);
        arr[arr.length-1] = num;

        int i = arr.length-1;
        while (i > 1) {
            if(arr[i/2] > arr[i]) break; // float up
            swap(arr, i, i/2);
            i /= 2;
        }
        if(log) System.out.println("after offer: " + Arrays.toString(arr));
    }

    /**
     * Remove root node. replace its place with the last of the complete tree, then
     * float downward until the the lowest layer.
     *
     * @return
     */
    public int poll() {
        int max = arr[1];

        swap(arr, 1, arr.length-1);
        resize(-1);

        int length = arr.length;
        int i = 1;
        while(i < length) { // float down
            if(i*2 >= length) {
                break; // no left and right
            } else if(i*2 + 1 < length) { // both left and right
                if(arr[i] > arr[i*2] && arr[i] > arr[2*i + 1]) break;

                int toSwap = arr[i*2] > arr[i*2 + 1] ? i*2 : i*2+1;
                swap(arr, i, toSwap);
                i = toSwap;
            } else { // only left without right
                if(arr[i] > arr[i*2]) break;
                ArrayUtil.swap(arr, i, i*2);
                i = i*2;
            }
        }
        if(log) System.out.println("after poll:  " + Arrays.toString(arr));
        return max;
    }

    public int peek() {
        return arr[1];
    }

    public String toString() {
        return Arrays.toString(arr);
    }

    @Test
    public void test() {
        Heap heap = new Heap();
        heap.log = true;
        heap.offer(1);
        heap.offer(2);
        heap.offer(6);
        heap.offer(8);
        heap.offer(3);
        heap.offer(7);
        heap.offer(5);
        heap.offer(9);
        heap.offer(4);

        heap.poll();
        heap.poll();
        heap.poll();
    }
}
