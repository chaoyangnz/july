package chapter2.section5.problems;

import org.junit.Test;

/**
 * 一个台阶总共有n 级，如果一次可以跳1 级，也可以跳2 级。
 * 求总共有多少总跳法，并分析算法的时间复杂度。
 */
public class P1_ClimbStairs {

    public static int climbStairs(int n) {
        int f_n_2 = 1;
        int f_n_1 = 2;
        if(n == 1) return f_n_2;
        if(n == 2) return f_n_1;
        int f_n = 0;
        for(int i=3; i <= n; ++i) {
            f_n = f_n_2 + f_n_1;
            f_n_2 = f_n_1;
            f_n_1 = f_n;
        }

        return f_n;
    }

    @Test
    public void test() {
        for(int i = 1; i < 10; ++i) {
            System.out.println(climbStairs(i));
        }
    }
}
