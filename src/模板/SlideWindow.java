package 模板;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


//单调队列的使用
public class SlideWindow {

    static int N = 1000010, hh = 0, tt = -1;
    static int[] q = new int[N];
    static int[] a = new int[N];

    public static void main(String[] args) throws Exception {
        //1 3 -1 -3 5 3 6 7
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] v = br.readLine().split("\\s+");
        int n = Integer.parseInt(v[0]);
        int k = Integer.parseInt(v[1]);
        v = br.readLine().split("\\s+");
        for (int i = 0; i < n; ++i) {
            a[i] = Integer.parseInt(v[i]);
        }
        for (int i = 0; i < n; ++i) {
            // 判断队头是否已经滑出窗口, 如果滑出窗口, 则弹出队首元素,维护窗口大小不超过 k, 每次值滑动一次, 所以可以使用 if
            if (hh <= tt && i - k + 1 > q[hh]) {
                hh++;
            }
            // 寻找窗口中的最小值
            while (hh <= tt && a[q[tt]] >= a[i]) {
                tt--;
            }
            // 将本轮下标添加到队列中
            q[++tt] = i;

            // 保证满足窗口大小, 比如窗口大小为 3, 不能此时只进入 2个数字
            //到达k长度打印
            if (i >= k - 1) {
                bw.write(a[q[hh]] + " ");
            }

        }
        bw.write("\n");
        hh = 0;
        tt = -1;
        for (int i = 0; i < n; ++i) {
            if (hh <= tt && i - k + 1 > q[hh]) {
                hh++;
            }
            while (hh <= tt && a[q[tt]] <= a[i]) {
                tt--;
            }
            q[++tt] = i;
            if (i >= k - 1) {
                bw.write(a[q[hh]] + " ");
            }
        }
        bw.flush();
        bw.close();
    }
}
