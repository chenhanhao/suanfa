import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();//人数
        int sum = 0;
        int a = 1;
        int b = 1;
        int index = 1;
        int p = n;

        //计算分子
        while(p>1){
            a = a * (p-1);
            p--;
        }

        //1- n 个人
        for(int k = 1; k<= n ; k++) {
           while(index < n){
               b = b*index*(index+1);
               sum = sum + (a/b);
               index++;

           }
        }

       // System.out.println(Integer.MAX_VALUE);
       System.out.println(sum);



        }
    }

