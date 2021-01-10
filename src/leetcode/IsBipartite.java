package leetcode;

import java.util.Arrays;

public class IsBipartite {

    static final int N=100010;
    int[] h=new int[N];
    int[] ne=new int[N];
    int[] e=new int[N];
    int idx;

    int[] color=new int[N];

    public void add(int a,int b){
        e[idx]=b;
        ne[idx]=h[a];
        h[a]=idx++;

    }

    public boolean dfs(int u,int c){

        color[u] = c;
        for (int i = h[u]; i != -1; i = ne[i]) {
            int j = e[i];
            if (color[j] == 0) {
                if (!dfs(j, 3 - c)){
                    return false;
                }
            }else if (color[j] == c) {
                return false;
            }
        }

        return true;

    }
    public boolean isBipartite(int[][] graph) {
        int n=graph.length;

        Arrays.fill(h,-1);

        for (int i = 0; i <n ; i++) {
            for (int j = 0; j <graph[i].length ; j++) {
                add(i,graph[i][j]);
            }
        }


        boolean res=true;

        for (int i = 0; i <n ; i++) {
            if(color[i]==0){
                if(!dfs(i,1)){
                    res=false;
                    break;
                }
            }
        }
//        Arrays.stream(color).forEach(num -> System.out.println(num));

        return res;



    }
}
