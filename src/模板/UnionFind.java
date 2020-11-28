package 模板;

import java.util.Scanner;

public class UnionFind {

    static final int N = 10010;

    static int n;

    static int[] p = new int[N];

    static int[] size = new int[N];


    //自带路径压缩 在回溯的时候将所有点的父节点赋值为根节点
    private static int find(int x) {
        if (p[x] != x) {
            p[x] = find(p[x]);
        }
        return p[x];
    }

    private static void union(int x, int y) {
        p[find(x)] = p[find(y)];
    }

    public static void main(String[] args) {


        for (int i = 0; i < n; i++) {
            p[i] = i;
            size[i] = 1;
        }

        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        //将两点所在集合 合并
        p[find(a)] = p[find(b)];
        //维护两集合点的数量
        size[find(a)] += size[find(b)];
    }


}
