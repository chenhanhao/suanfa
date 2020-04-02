package 算法小炒.动规;

public class _3_凑零钱问题 {
     public static void main(String[] args) {
         int[] coins = {1,2,5};
         int amount = 11;
         int i = coinChange2(coins, amount);
         System.out.println(i);

     }

    public static int coinChange(int[] coins, int amount) {
         int[] arr = new int[amount+1];

        return  dp2(arr,coins, amount);

    }


    //dp数组迭代解法
    public static int coinChange2(int[] coins, int amount) {
        int[] dp = new int[amount+1];

        dp[0] = 0;

        for(int i = 0; i< dp.length;i++){
            for(int j=0; j<coins.length; j++){
                if(i-coins[j]<0){
                    continue;
                }
                if(i-coins[i]<0) continue;
                dp[i] = Math.min(dp[i],1+dp[i-coins[i]]);
            }
        }
        return  (dp[amount] == amount + 1) ? -1 : dp[amount];


    }


    //普通动规
    public static int dp(int[] coins, int amount){

         if(amount==0){
             return 0;
         }
         if(amount<0){
             return -1;
         }

         int res = Integer.MAX_VALUE;
         for(int i = 0; i< coins.length;i++){
             int temp = dp(coins,amount-coins[i]);
             if(temp==-1){
                 continue;
             }
             res = Math.min(res,1+temp);
         }
         return res == Integer.MAX_VALUE? -1: res;

    }


    //加入备忘录
    public static int dp2(int[] arr, int[] coins, int amount){

        if(amount==0){
            return 0;
        }
        if(amount<0){
            return -1;
        }

        if(arr[amount]!=0){
            return arr[amount];
        }

        int res = Integer.MAX_VALUE;
        for(int i = 0; i< coins.length;i++){
            int temp = dp2(arr,coins,amount-coins[i]);
            if(temp==-1){
                continue;
            }
            res = Math.min(res,1+temp);

        }
         int rs =  res== Integer.MAX_VALUE? -1: res;
         arr[amount] = rs;
        return rs;

    }



}
