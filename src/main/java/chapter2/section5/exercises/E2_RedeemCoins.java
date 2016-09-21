package chapter2.section5.exercises;

import org.junit.Test;

/**
 * Created by richard on 9/21/16.
 */
public class E2_RedeemCoins {
    public static int redeemCoins(int N) {
        int[] dimes = { 1, 2, 5, 10 };
        int[] arr = new int[N+1];
        for(int i = 1; i <= N; ++i) {
            arr[i] = 1;
        }
        for (int dime : dimes)
        {
            for (int j = dime; j <= N; ++j)
            {
                arr[j] += arr[j - dime];
            }
        }

        return arr[N];
    }

    @Test
    public void test() {
        for(int i = 1; i <= 100; ++i) {
            System.out.println(String.format("Notes %d ways to redeem: %d", i, redeemCoins(i)));
        }

        int N = 100;
        int[] arr = new int[N+1];
        arr[1] = 1;
        arr[2] = 2;
        arr[3] = arr[1] + arr[2];

    }
}
