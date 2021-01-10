package leetcode;

public class NumDecodings {

    public int numDecodings(String s) {

        if(s.length()==0) return 0;
        int n=s.length();

        int[] f=new int[s.length()+1];

        f[0]=1;
        for (int i = 1; i <=n ; i++) {

            if(s.charAt(i-1)<'0'||s.charAt(i-1)>'9'){
                return 0;
            }

            f[i]=0;

            if(s.charAt(i-1)!='0'){
                f[i]=f[i-1];
            }

            if(i>1){
                int t=(s.charAt(i-2)-'0')*10+s.charAt(i-1)-'0';
                if(t>=10&&t<=26){
                    f[i]+=f[i-2];
                }
            }
        }

        return f[n];


    }
}
