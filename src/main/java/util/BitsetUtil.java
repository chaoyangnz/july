package util;

/**
 * Each int can represent the existence of 32 numbers.
 */
public final class BitsetUtil {

    public static void set(int[] bitmap, int num) {
        int index = num / Integer.SIZE;
        int offset = num % Integer.SIZE;
        bitmap[index] |= 1 << offset;
    }
    
    public static void clear(int[] bitmap, int num) {
        int index = num / Integer.SIZE;
        int offset = num % Integer.SIZE;
        bitmap[index] &= ~(1 << offset);
    }

    public static boolean get(int[] bitmap, int num) {
        int index = num / Integer.SIZE;
        int offset = num % Integer.SIZE;
        return (bitmap[index] & 1 << offset) > 0;
    }
}
