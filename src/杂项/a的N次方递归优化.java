package 杂项;

import java.util.HashMap;
import java.util.Map;

public class a的N次方递归优化 {

     public static void main(String[] args) {
         int a = 3;
         int n = 9;

       System.out.println(digui(a,n));

     }

     static Map<Integer,Integer> map = new HashMap<>();

    public static int digui(int a, int n){
        if(n==1){
            return a;
        }

        if(n%2==0){
            //偶数
            if(map.get(n)==null) {
                n = n>>1;
                int temp = digui(a, n) * digui(a, n);
                map.put(n>>1, temp);
                return temp;
            }
            else {
                return map.get(n)*map.get(n);
            }
        }
        else{
            //奇数
            if(map.get(n)==null) {
                n = n>>1;
                int temp = digui(a, n) * digui(a, n+1);
                map.put(n>>1, temp);
                return temp;
            }
            else {
                return map.get(n)*map.get(n);
            }
        }
    }
}
