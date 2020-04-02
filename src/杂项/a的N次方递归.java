package 杂项;

public class a的N次方递归 {

    public static void main(String[] args) {
        System.out.println(digui(3,9));
    }


    public static int digui(int a, int n){
        if(n==1){
            return a;
        }

        if(n%2==0){
            //偶数
            n = n>>1;
            return digui(a,n) * digui(a,n);
        }
        else{
            //奇数
            n = n>>1;
            return digui(a,n+1) * digui(a,n);
        }
    }
}
