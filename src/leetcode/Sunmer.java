package leetcode;

public class Sunmer {


    public static void main(String[] args) {
        int[] ints = new int[]{20884,
                25245,
                32006,
                27217,
                24491,
                20387,
                41879,
                38061,
                32100,
                48652,
                42612,
                44165,
                39712,
                36040,
                36765,
                32979,
                33170,
                38409,
                35324,
                49808,
                41859,
                26675,
                50915,
                44995,
                30210,
                9348,
                12894,
                17954,
                17473,
                17968,};

        int sum = 0;
        for (int n : ints) {
            sum += n;
        }

        System.out.println(sum);
    }
}
