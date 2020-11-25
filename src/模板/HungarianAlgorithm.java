package 模板;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class HungarianAlgorithm {

    static final int N = 510, M = 100010;


    static int n1, n2, m;
    static int[] h = new int[N];
    static int[] e = new int[M];
    static int[] ne = new int[M];
    static boolean[] st = new boolean[N];


    static int[] match = new int[N];
    static int idx;


    private static void add(int a, int b) {

        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;

    }


    private static boolean find(int u) {


        // 遍历x号男生看上的所有女生

        for (int i = h[u]; i != -1; i = ne[i]) {

            int j = e[i];
            if (!st[j]) {// 防止重复匹配

                st[j] = true;
                if (match[j] == 0 || find(match[j])) {// 如果j号女生还没有匹配到男生或者她匹配到的男生可以找到下家
                    match[j] = u;// 就把j匹配给x
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {

        Arrays.fill(h, -1);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] s = bufferedReader.readLine().split(" ");
        n1 = Integer.parseInt(s[0]);
        n2 = Integer.parseInt(s[1]);
        m = Integer.parseInt(s[2]);

        while (m-- > 0) {
            String[] s1 = bufferedReader.readLine().split(" ");
            int a = Integer.parseInt(s1[0]);
            int b = Integer.parseInt(s1[1]);
            add(a, b);
        }

        int res = 0;
        for (int i = 0; i <= n1; i++) {

            Arrays.fill(st, false);

            if (find(i)) res++;

        }

        System.out.println(res);


    }
}
