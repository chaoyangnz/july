package util;

/**
 * Created by richard on 9/16/16.
 */
public final class ArrayUtil {

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
