package 八大排序.交换排序;

import java.util.Arrays;

/**
 * 冒泡排序的思想是：
 * 像冒泡一样，大的向上浮，小点向下浮
 * 遍历数组，两两比较，大的交换到后者，一趟循环下来，最大的就到了最后面
 *
 */
public class 冒泡排序 {
       public static void main(String[] args) {
           int[] a = {3,5,8,32,13,51,325,2,8,9,5,8,45,45,43,413};

           int temp;
           for(int i = 0; i<a.length-1; i++){
               boolean b = true;//设置一个标志来减少复杂度
               for(int j = i+1; j<a.length; j++){
                   if(a[i]>a[j]){
                       temp = a[i];
                       a[i] = a[j];
                       a[j] = temp;
                       b = false;
                   }
                   if(b){
                       continue;
                   }
               }
           }


           System.out.println(Arrays.toString(a));


       }


}
