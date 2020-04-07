package Lecode;

public class _最长递增子序列长度 {
     public static void main(String[] args) {
          int[] num = {1,4,3,4,2,3};
          int check = check(num);
          System.out.println(check);
     }


     public static int check(int[] num){
          int[] dp = new int[num.length];
         for(int i = 0 ; i< num.length;i++){
             dp[i]  =1;
         }

          //拿到某个数据项
        for(int i = 0 ; i< num.length; i++){
             for(int j = 0 ; j < i; j++){
                  if(num[j] < num[i]){
                       dp[i] = Math.max(dp[i],dp[j]+1);
                  }
             }
        }

        int re=0;
        for(int i = 0; i< dp.length; i++){
             re  =Math.max(dp[i],re);
        }

        return  re;

     }
}
