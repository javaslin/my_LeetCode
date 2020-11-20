package leetcode;

public class Fib {
    public int fib(int N) {
        if (N <= 0) {
            return N;
        }
        int[] m = new int[N + 1];
        m[0] = 0;
        m[1] = 1;
        for (int i = 2; i <= N; i++) {
            m[i] = m[i - 1] + m[i - 1];
        }
        return m[N];
    }
}
