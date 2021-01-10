package leetcode;

public class MaximumSwap {
    public static int maximumSwap(int num) {
        String numString=String.valueOf(num);
        char max='0';
        int position=0;
        char[] chars = numString.toCharArray();
        int t=0;
        for (int i = 0; i <chars.length-1 ; i++) {
            if (chars[i] < chars[i + 1]) {
                t = i + 1;
                break;
            }
        }
        for (int i = t; i <chars.length ; i++) {
            position=max>=chars[i]?position :i;
            max=max>=chars[i]?max :chars[i];

        }
        System.out.println("position"+position);
        System.out.println("max"+max);
        for (int i = 0; i <chars.length ; i++) {
            if(chars[i]<max){
                char temp=chars[i];
                chars[i]=max;
                chars[position]=temp;
                break;
            }
        }
        StringBuilder sb=new StringBuilder();
        for (int i = 0; i <chars.length ; i++) {
            sb.append(chars[i]);
        }
        return Integer.parseInt(sb.toString());

    }

    public static void main(String[] args) {
        maximumSwap(9973);
    }
}
