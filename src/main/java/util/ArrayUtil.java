package util;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by richard on 9/16/16.
 */
public final class ArrayUtil {

    public static class Range {
        public int from;
        public int to;

        public String toString() {
            return String.format("[%d ~ %d]", from, to);
        }
    }

    /**
     * Split a char array using the specified delimiter
     *
     * @param chars
     * @param delimiter
     * @return ranges with words
     */
    public static Range[] split(char[] chars, char delimiter) {
        final int N = chars.length;
        int i = 0;

        int count = 0;
        List<Range> ranges = new ArrayList<Range>();

        while (i < N) {
            int j = i;
            while (j < N && chars[j] == delimiter) {
                j++;
            }
            if(j == N) break;

            Range range = new Range();
            range.from = j;

            while(j < N && chars[j] != delimiter) {
                j++;
            }

            range.to = j-1;
            ranges.add(range);

            i = j;
        }

        Range[] rangeArr = new Range[ranges.size()];
        return ranges.toArray(rangeArr);
    }

    public static <T> void print(T[] arr) {
        for(int i=0; i < arr.length; ++i) {
            System.out.println(arr[i]);
        }
    }

    public static void print(char[] arr) {
        System.out.println(arr);
    }

    /**
     * Swap the elements in index i and j
     *
     * @param arr
     * @param i
     * @param j
     */
    public static void swap(char[] arr, int i, int j) {
        assert arr != null;
        assert i >= 0 && i < arr.length;
        assert j >= 0 && j < arr.length;

        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * Reverse the elements from index i to j
     *
     * @param arr
     * @param i
     * @param j
     */
    public static void reverse(char[] arr, int i, int j) {
        assert arr != null;
        assert i >= 0 && i < arr.length;
        assert j >= 0 && j < arr.length;
        assert i <= j;

        while (i < j) {
            swap(arr, i++, j--);
        }
    }

    /**
     * Reverse the whole array
     *
     * @param arr
     */
    public static void reverse(char[] arr) {
        reverse(arr, 0, arr.length - 1);
    }

    /**
     * Reverse the suffix of array from index i
     *
     * @param arr
     * @param i
     */
    public static void reverseSuffix(char[] arr, int i) {
        reverse(arr, i, arr.length - 1);
    }

    /**
     * Reverse the prefix of array until index i
     *
     * @param arr
     * @param i
     */
    public static void reversePrefix(char[] arr, int i) {
        reverse(arr, 0, i);
    }
}
