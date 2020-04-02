package 牛客剑指offer;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 */
/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级，也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 */


/**
 *  青蛙跳台阶有两种情况
 *  假如跳1级，则剩下 n-1级台阶需要跳
 *  假如调2级，则剩下 n-2级台阶需要跳
 */
public class _7_青蛙变态跳台阶 {
     public static void main(String[] args) {
                System.out.println(jump(3));
     }

    public  static  int jump(int n){


        if(n <= 2){
            return n;
        }
        else{
            return jump(n-1)+jump(n-2);
        }

    }

    public  static  int jump2(int n){

       //将前面的总数加上去
        int sum = 3;
        if(n <=2){
            return n;
        }
        else {
            for(int i = 3; i<=n;i++){
                 sum*=2;
            }

        }
        return sum;

    }

}
