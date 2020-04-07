package 算法小炒.动规;

public class _5_打家截舍系列 {
     public static void main(String[] args) {

     }

    int rob(int[] nums) {
         int n = nums.length;

         int[] dp = new int[n+2];

         //从后向前
         for(int i = n-1; i >= 0; i--){
             dp[i] = Math.max(dp[i+1],nums[i] + dp[i+2]);
         }
         return dp[0];
    }

    int rob2(int[] nums) {
        int n = nums.length;

        int dp_i=0, dp_i_1 = 0, dp_i_2 = 0;

        //从后向前
        for(int i = n-1; i >= 0; i--){
            dp_i = Math.max(dp_i_1,nums[i] + dp_i_2);
            dp_i_2 = dp_i_1;
            dp_i_1 = dp_i;

        }
        return dp_i;
    }
}
