package 熟练背诵;

/**
 * @author lin.shi on 2021/6/30
 * @project my_LeetCode
 */
public class Mooofish {



    public static int prefixSum(int[] nums,int l,int r){

        int[] sum=new int[nums.length+1];
        sum[0]=0;
        for (int i = 1; i < nums.length+1 ; i++) {
            sum[i]=sum[i-1]+nums[i-1];
        }

        return sum[r]-sum[l-1];

    }

    public static boolean binarySearch(int[] nums,int target){
        int l=0,r=nums.length-1;
        while (l<=r){
            int mid=l+((r-l)>>1);
            if(nums[mid]==target){
                return true;
            }else if(nums[mid]>target){
                r=mid-1;
            }else {
                l=mid+1;
            }
        }

        return false;

    }




    public static void main(String[] args) {
//        int[] nums = new int[]{3, 5, 2, 7, 4, 9, 5};
//        System.out.println(prefixSum(nums,3,7));


        int[] nums = new int[]{2, 4, 5, 3, 7, 4, 3, 9, 10, 45, 34, 56};
        System.out.println(binarySearch(nums, 34));
    }


}
