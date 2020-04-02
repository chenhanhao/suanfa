package 牛客剑指offer;

import java.util.Arrays;

/**
 * HZ偶尔会拿些专业问题来忽悠那些非计算机专业的同学。今天测试组开完会后,他又发话了:在古老的一维模式识别中,
 * 常常需要计算连续子向量的最大和,当向量全为正数的时候,问题很好解决。但是,如果向量中包含负数,是否应该包含某个负数,
 * 并期望旁边的正数会弥补它呢？例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)
 * 。给一个数组，返回它的最大连续子序列的和，你会不会被他忽悠住？(子向量的长度至少是1)
 */
public class _22_最大连续子序列的和 {

     public static void main(String[] args) {
         int[] arr = {6,-3,-2,7,-15,1,2,2};
         System.out.println(FindGreatestSumOfSubArray(arr));


     }

    public static int FindGreatestSumOfSubArray(int[] array) {
         int[] dp = new int[array.length];

         //动态规划
         //dp[i] 表示以包含第i个位置上的数结尾的最长连续子序列
         //dp[i] = Math(dp[i-1]+array[i]，array[i])
         dp[0] = array[0];
         for(int i = 1 ; i<array.length ; i++){
             dp[i] = Math.max(dp[i-1]+array[i],array[i]);
         }

         System.out.println(Arrays.toString(dp));
         int max = Integer.MIN_VALUE;
         for(int j = 0 ; j < array.length ; j++){

             if(dp[j] > max){
                 max = dp[j];
             }
         }

         return  max;
    }
}
