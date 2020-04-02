package 算法小炒.动规;

import java.util.HashMap;

//备忘录优化，使用数组或者哈希表
public class _2_斐波那契数 {
     public static void main(String[] args) {
         System.out.println(fib2(4));

     }


     //备忘录,数组
    public static int fib(int n){
         if(n<1) return 0;
         int[] dp = new int[n+1];
         return helper(dp,n);
    }

    public static int helper(int[] dp,int  n){
         if(n==1|| n==2) return 1;
         else {
             if(dp[n]!=0) return dp[n];
             dp[n] = helper(dp,n-1)+helper(dp,n-2);
         }
         return dp[n];
    }

    //备忘录再优化
    public static int fib1(int n){
        int[] dp = new int[n+1];
        dp[1] = dp[2] = 1;
        for(int i = 3;i<=n;i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return  dp[n];
    }




    //斐波那契数 map
    public static  int fib2(int n){
     if(n<1){
         return 0;
     }
     HashMap<Integer,Integer> map = new HashMap<>();
     return helper2(map,n);
    }

    public static int helper2(HashMap<Integer,Integer> map , int n){
         if(n==1|| n==2){
             return 1;
         }
         if(map.containsKey(n)){
             return map.get(n);
         }
         else {
             map.put(n,helper2(map,n-1)+helper2(map,n-2));
         }
         return  map.get(n);

    }
}
