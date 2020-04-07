package 算法小炒.动规;

public class _887_鸡蛋掉落 {
     public static void main(String[] args) {
         int i = superEggDrop(3, 14);
         System.out.println(i);

     }

    public static  int superEggDrop(int K, int N) {
         int[][] dp = new int[N+1][K+1];

        for(int i = 0 ; i<= N; i++){
            for(int j = 0 ; j<= K; j++){
                dp[i][j] = Integer.MAX_VALUE;
            }


        }

         for(int i = 0 ; i<= N; i++){
             dp[i][1] = i; //只有一个鸡蛋，只能进行线性扫描

         }
        for(int i = 0 ; i<= K; i++){
             dp[0][K] = 0; //没有楼层，只有1

        }

         //状态  K个鸡蛋 N层楼
         //选择 从那一层扔，楼层数最小与1
        for(int i = 1; i<= N; i++){
            //鸡蛋的个数超过2个，不然就是直接线性扫描
            for(int j = 2; j<=K; j++){
                //选择
                //鸡蛋碎，等于子问题，鸡蛋没碎，则需要子问题加上1
                dp[i][j]  =  Math.min(dp[i][j],Math.max(dp[N-i][j],dp[i-1][j-1]) + 1);
            }

        }

      return dp[N][K];

    }
}
