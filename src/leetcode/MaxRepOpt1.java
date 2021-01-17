package leetcode;




import java.util.Arrays;

public class MaxRepOpt1 {

    private int max;


    public int maxRepOpt1(String text) {
        int count=0;
        for (int k = 0; k < text.length()-1 ; k++) {
            if(text.charAt(k)!=text.charAt(k+1)){
                count++;
            }
        }
        if(count>0){
            return text.length();
        }
        for (int i = 0; i <text.length(); i++) {
            for (int j = i+1; j <text.length(); j++) {
                if(text.charAt(i)!=text.charAt(j)){
                    exchangeChar(i,j,text);
                }
            }
        }

        return max;

    }

    public void exchangeChar(int i,int j,String text){
        char[] chars = text.toCharArray();
        char temp=chars[i];
        chars[i]=chars[j];
        chars[j]=temp;
        System.out.println(new String(chars));
        int count=0;
        for (int k = 0; k < chars.length-1 ; k++) {

            if(chars[k]==chars[k+1]){
                count++;
                max=Math.max(max,count);
            }else {
                count=1;
            }
        }
    }


}
