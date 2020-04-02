package 杂项;

import java.util.Arrays;

/**
 * dfs全排列
 */
public class dfs {

    public static void main(String[] args) {
         dfs(0);
    }
    static int[]a = {1,2,3,4};
    static int size  = a.length;

    private static void dfs(int l) {
        //定义出口
        if(l>=size-1) {
            System.out.println(Arrays.toString(a));
        }


        //每次固定住一个数，让后面的数随机排列
        for(int i=l ; i<size;i++ ) {
            swap(i,l);
            dfs(i+1);
            swap(i,l);

        }


    }
    private static void swap(int i, int j) {
        int temp = 0;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;

    }
}


