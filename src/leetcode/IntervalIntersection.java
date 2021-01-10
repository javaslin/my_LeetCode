package leetcode;

import java.util.ArrayList;
import java.util.List;

public class IntervalIntersection {

    class Pair{
        int start;
        int end;
        Pair(int start,int end){
            this.start=start;
            this.end=end;
        }
    }
    public int[][] intervalIntersection(int[][] A, int[][] B) {


        List<Pair> listA=new ArrayList<>();
        List<Pair> listB=new ArrayList<>();
        List<Pair> listRes=new ArrayList<>();
        int pointA=0,pointB=0;

        for (int i = 0; i <A.length ; i++) {
            int start=A[i][0];
            int end=A[i][1];
            Pair pair=new Pair(start,end);
            listA.add(pair);
        }
        for (int i = 0; i <B.length ; i++) {
            int start=B[i][0];
            int end=B[i][1];
            Pair pair=new Pair(start,end);
            listB.add(pair);
        }

        while (pointA < A.length && pointB < B.length) {
            Pair pairA=listA.get(pointA);
            Pair pairB=listB.get(pointB);

            if (pairA.start <= pairB.end && pairA.end>=pairB.start) {
                int start=Math.max(pairA.start,pairB.start);
                int end=Math.min(pairA.end,pairB.end);
                Pair newPair=new Pair(start,end);
                listRes.add(newPair);
                if(pairA.end>pairB.end ){
                    pointB++;
                }else {
                    pointA++;
                }
            }else {
                if(pairA.end>pairB.end ){
                    pointB++;
                }else {
                    pointA++;
                }
            }
        }
//        System.out.println(pointA);
//        System.out.println(pointB);
//        while (pointA<A.length){
//            listRes.add(listA.get(pointA));
//            pointA++;
//        }
//        while (pointB<B.length){
//            listRes.add(listB.get(pointB));
//            pointB++;
//        }

        int[][] res=new int[listRes.size()][2];
        for (int i = 0; i <listRes.size() ; i++) {
            res[i][0]=listRes.get(i).start;
            res[i][1]=listRes.get(i).end;
        }

        return res;


    }
}
