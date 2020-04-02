package 算法小炒.动规;

public class _1_斐波那契数 {
     public static void main(String[] args) {
         System.out.println(fib(4));

     }

     //斐波那契数
    public static  int fib(int n){
         if(n==1|| n==2){
             return 1;
         }
         else {
             return fib(n-1)+fib(n-2);
         }

    }




}
