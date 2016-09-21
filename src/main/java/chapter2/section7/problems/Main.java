package chapter2.section7.problems;

import org.junit.Test;
import util.ArrayUtil;

/**
 * Created by richard on 9/21/16.
 */
public class Main {

    public static void bar(char[] balls) {
        final int N = balls.length;

        int begin = 0;
        int end = N-1;
        int current = 0;
        while(current <= end) {
            if(balls[current] == 'r') {
                ArrayUtil.swap(balls, begin, current);
                begin++;
                current++;
            } else if(balls[current] == 'b') {
                ArrayUtil.swap(balls, end, current);
                end--;
            } else {
                current++;
            }
            ArrayUtil.print(balls);
        }
    }

    public void foo(char[] balls) {
        final int N = balls.length;

        // make red before white or blue
        int red = -1;
        int i = 0;
        while(i < N && red < i) {
            if(balls[i] == 'r') {
                red++;
                ArrayUtil.swap(balls, i, red);
            }
            i++;
        }

        System.out.print("reorder red and white/blue: ");
        ArrayUtil.print(balls);

        // make white before blue
        int white = red;
        i = white+1;
        while(i < N && white < i) {
            if(balls[i] == 'w') {
                white++;
                ArrayUtil.swap(balls, i, white);
            }
            i++;
        }

        System.out.print("then reorder white and blue: ");
        ArrayUtil.print(balls);
    }

    @Test
    public void test() {
        char[] balls = {'r', 'w', 'b', 'b', 'w', 'r', 'b', 'w', 'b', 'w', 'r', 'r', 'b'};
        bar(balls);
//        ArrayUtil.print(balls);
    }
}
