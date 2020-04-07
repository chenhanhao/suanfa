package 算法小炒.动规;

public class _72_编辑距离 {
     public static void main(String[] args) {
         String  word1 = "horse", word2 = "ros";
         int i = minDistance(word1, word2);
         System.out.println(i);

     }


     //自底向上
    public static int minDistance(String word1, String word2) {
         int m = word1.length();
         int n = word2.length();
        char[] char1 = word1.toCharArray();
        char[] char2 = word2.toCharArray();

        int[][] dp = new int[m+1][n+1];

         for(int i = 1; i<=m; i++){
             //如果另一个为空，删除，需要操作i步
             dp[i][0] = i;
         }
         for(int j = 1; j<= n;j++){
             //如果另一个为空，删除，需要操作j步
             dp[0][j] = j;
         }

         for(int i = 1; i<= m;i++){
             for(int j=1; j<= n;j++){
                 if(char1[i-1]==char2[j-1]){
                     //相等的时候，什么都不做
                     dp[i][j] = dp[i-1][j-1];
                 }

                 else {
                     //三种选择，是删除好，添加好，还是替换好
                     dp[i][j] = Math.min(Math.min(dp[i-1][j]+1,dp[i][j-1]+1),dp[i-1][j-1]+1);
                 }
             }
         }

         return dp[m][n];


    }

    //使用递归
    public static int minDistance2(String word1, String word2) {
        char[] wo1 = word1.toCharArray();
        char[] wo2 = word2.toCharArray();

        int dp = dp(wo1, wo2, wo1.length - 1, wo2.length - 1);
        return  dp;

    }

    //有两个指针代表单前比较的字符串
    public static int dp(char[] wo1, char[] wo2, int i, int j){
         //递归，需要找到出口
        if(i==-1 ) return j+1; //另一个数没了，需要执行剩下的j+1步操作
        if(j==-1) return i+1;//同理

        if(wo1[i] == wo2[j]){
            //如果想等，则访问两个字符的下一个
            return dp(wo1,wo2,i-1,j-1);
        }
        else{
            //进行删除，添加，修改
           return   Math.min(Math.min(dp(wo1,wo2,i-1,j)+1 ,dp(wo1,wo2,i,j-1) +1),dp(wo1,wo2,i-1,j-1)+1 );
        }


    }
}
