package 杂项;

public class 欧几里得算法 {
     public static void main(String[] args) {

         int num = gcd(8, 4);
         int num2 = getNum3(255, 45);
         System.out.println(num);
         System.out.println(num2);
     }

    /**
     * 最简便的写法
     * @param a
     * @param b
     * @return
     */
    static int gcd(int a,int b) {
        return b==0?a:gcd(b,a%b);
    }


    /**
     * 用欧几里得求最大公约数，辗转相除法
     */
    static int getNum(int n , int m){
        int big = n>m ? n:m;
        int small = n<m ? n:m;

        if(big%small == 0){
            return small;
        }
        else {
            return getNum(small,big%small);
        }
    }

    /**
     * 欧几里得 非递归
     * @param n
     * @param m
     * @return
     */
    static int getNum2(int n , int m){
        int big = n>m ? n:m;
        int small = n<m ? n:m;

       while(small!=0){
           int temp = big%small;
           big = small;
           small = temp;
       }
       return big;
    }

    //课本的写法
    static int getNum3(int a,int  b){
        int x = a;
        int y = b;
        while(true) {
            if (y == 0){
                return x;
            }
            else{
                int temp = x%y;
                x = y;
                y = temp;
            }
        }
    }





}
