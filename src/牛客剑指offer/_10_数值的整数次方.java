package 牛客剑指offer;

/**
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 */
public class _10_数值的整数次方 {



     public static void main(String[] args) {
         System.out.println(2&1);
         System.out.println(3&1);
         System.out.println(Power(6,3));
         System.out.println(Power2(3,4));
     }


    public static double Power(double base, int exponent) {
        if(exponent==0){
            return 1;
        }

        else{
            double  num = base;
            int i = 1;
            while((i<<1) <= exponent){
                num *= num;
                i <<= 1;
            }
            return num * Power(base,exponent-i);
        }
    }


    public static double Power2(double base, int exponent) {
        if(exponent==0){
            return 1;
        }

        else{
            double  num = base;
            double temp = 1;
            if((exponent&1)==1){
                //奇数
                temp = base;
            }
            while(exponent!=1){
                 num *= num;
                 exponent >>=  1;
            }

            return num*temp;
        }
    }
}
