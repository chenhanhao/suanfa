package 算法小炒.动规;

public class _4_01背包问题 {
     public static void main(String[] args) {
         int w = 6;//背包的质量
         int n = 3;//n个物品
         int[] wt = {1,4,3};
         int[] val = {2,4,3};
         System.out.println(knapsack(w,n,wt,val));

     }


    public  static int   knapsack(int W, int N, int[] wt, int[] val){
         int [][] dp = new int[N+1][W+1];
         for(int i = 0 ;i < W; i++){
             dp[0][i] = 0;
         }
        for(int i = 0 ;i < N; i++){
            dp[i][0] = 0;
        }


        for(int n = 1; n<=N; n++){
             for(int w =1; w<=W; w++){
                 //装不下,n-1是因为初始化是1 ,w=1
                 if(wt[n-1]>w){
                     dp[n][w] = dp[n-1][w];
                 }
                 else {
                     dp[n][w] = Math.max(dp[n-1][w], dp[n-1][w-wt[n-1]]+val[n-1]);
                 }
             }
         }

         return dp[N][W];


    }

}
