package leetcode;

import java.util.PriorityQueue;

public class EatApple {
    static class Pair{
        int day;
        int appleCount;

        public Pair(int day, int appleCount) {
            this.day = day;
            this.appleCount = appleCount;
        }
    }
    public static int eatenApples(int[] apples, int[] days) {


        int res=0;
        PriorityQueue<Pair> queue=new PriorityQueue<>((o1, o2) -> o1.day - o2.day);
        int n=apples.length;
        Pair pair=new Pair(days[0],apples[0]);
        queue.add(pair);
        for (int i = 0; i < 40000; i++) {
            if (i<n &&apples[i]>0) {
                queue.add(new Pair(i+days[i]-1,apples[i]));
            }
            while (!queue.isEmpty()&&queue.peek().day<i){
                queue.poll();
            }
            if(queue.isEmpty()){
                continue;
            }
            Pair poll = queue.poll();
            res++;
            if(--poll.appleCount>0){
                poll.appleCount--;
                queue.add(poll);
            }


        }

        return res;


    }

    public static void main(String[] args) {
        int[] apples=new int[]{1,2,3,5,2};
        int[] days=new int[]{3,2,1,4,2};
        eatenApples(apples,days);
    }
}
