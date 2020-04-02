package Lecode;

/**
 * 打家截舍
 * 一个有名的按摩师会收到源源不断的预约请求，每个预约都可以选择接或不接。
 * 在每次预约服务之间要有休息时间，因此她不能接受相邻的预约。
 * 给定一个预约请求序列，替按摩师找到最优的预约集合（总预约时间最长），返回总的分钟数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/the-masseuse-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _17_按摩师 {
     public static void main(String[] args) {
         int[] arr = {2};
         int massage = massage(arr);
         System.out.println(massage);

     }

    public static int massage(int[] nums) {
         if(nums.length==0){
             return 0;
         }
        int  len = nums.length;
        int[] dp = new int[len+1];
            dp[0] = 0;
            dp[1] = nums[0];
            for(int i = 2; i<= nums.length; i++){
                dp[i] = Math.max(nums[i-1] + dp[i-2],dp[i-1]);

        }

        return dp[len];
    }


    //======打家截舍2，一个圈
    //分两种情况，第一种是打劫第一家不打劫最后一家，另一种是不打结第一家，打劫最后一家
    public static int massage2(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        int len = nums.length;
        int[] dp = new int[len+1];
        dp[0] = 0;
        dp[1] = nums[0];
        for(int i = 2; i<= nums.length; i++){
            dp[i] = Math.max(nums[i-1] + dp[i-2],dp[i-1]);

        }
        int a = dp[len-1];

        dp[1] = 0;//不打劫第一家
        for(int i = 2; i <= nums.length;i++){
            dp[i] = Math.max(nums[i-1] + dp[i-2],dp[i-1]);
        }

        return Math.max(dp[len],a);
    }
//==============
    public static int rob(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        if(nums.length==1){
            return nums[0];
        }
        int len = nums.length;
        int[] dp = new int[len+1];
        int[] dp2 = new int[len+1];
        dp[0] = 0;
        dp[1] = nums[0];
        dp2[0] = 0;
        dp2[1] = 0;
        for(int i = 2; i<= nums.length; i++){
            dp[i] = Math.max(nums[i-1] + dp[i-2],dp[i-1]);
            dp2[i] = Math.max(nums[i-1] + dp2[i-2],dp2[i-1]);
        }

        return Math.max(dp[len-1],dp2[len]);
    }
}
