package 杂项;

import java.util.Arrays;

/**
 * 一定范围内  n 和 n+2 均为素数的情况 如 ： (3,5) (5,7)
 */
public class 求一定范围内的孪生素数 {

     public static void main(String[] args) {
         int[] ints = prime3(20);

         System.out.println(Arrays.toString(ints));
     }


    //首先，应该有一个判断一个数是否是素数的方法，普通写法
    static boolean prime(int n){
        if(n<2){
            return false;
        }
        if(n==2 || n ==3 ){
            return true;
        }
        else{
            if(n%2==0){
                return true;
            }
            else{
                int a = (int)Math.sqrt(n);
                for(int i = 2; i <= a ; i++){
                    if(n % i == 0){
                        return false;
                    }
                }
                return true;
            }
        }
     }


     //埃式筛选，选出一定范围内的素数
    /**
     * 思路：我们设置一个素数数组，以及一个boolean类的判断单前数是否被筛选
     * 那么我们从第一个素数，2开始遍历，我们已知2为素数，将与2的倍数关系的数进行筛选，4,6,8....，这些都不是素数
     * 设置为被筛选掉的
     */
   static int[] prime2(int n){
         int[] prime = new int[n+1];//素数数组
         boolean[] is = new boolean[n+1];//筛选到的判断
         int cnt = 0;

         for(int i = 2; i<n; i++){
             //注意从2开始，因为最小的素数是2
             //默认情况下没有被筛选到
             if(!is[i]){
                 //将没有被筛选到的数加入素数数组
                 prime[cnt++] = i;
                 for (int j = i ; j<n;j+=i){
                     //对i的倍数进行筛选
                     //设置被筛选了的判断
                     is[j] = true;
                 }
             }
         }
         return prime;
     }


     //欧拉筛选（防止出现像 ，2，3都扫描到了6的重复情况的出现 ）
     //埃式筛选还是存在着对数据的重复筛选，使用欧拉筛选解决问题

    /**
     * 思路：首先，任何合数都能表示成多个素数的积。所以，任何的合数肯定有一个最小质因子。我们通过这个最小质因子就可以判断什么时候不用继续筛下去了。
     *       当i是prime[j]的整数倍时（i % prime[j] == 0），i*prime[j+1]肯定被筛过，跳出循环。
     * @param n
     * @return
     */
     static int[] prime3(int n){
         int[] prime = new int[n+1];//素数数组
         boolean[] is = new boolean[n+1];//筛选到的判断
         int cnt = 0;//素数数组的下标

         for(int i = 2; i<n; i++) {
             //注意从2开始，因为最小的素数是2
             //默认情况下没有被筛选到,加入数组
             if (!is[i]) {
                 prime[cnt++] = i;
                 is[i] = true;
             }

                 for(int j = 0 ; j<cnt; j++){
                     if(i*prime[j]>n) {//判断是否越界
                         break;
                     }
                     is[i*prime[j]]=true;//筛数

                     if(i%prime[j]==0) {//时间复杂度为O(n)的关键！
                         break;
                     }

                 }

         }
         return prime;
     }

}
