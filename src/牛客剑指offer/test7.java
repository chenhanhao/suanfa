package 牛客剑指offer;

import java.util.Arrays;

/**
 * @author ASNPIHA
 * @date 2019-12-16 5:32 PM
 */


public class test7 {

    public static void main(String[] args) {
      int[] a = {1,2,3,4,5,6,7,8};
      int[] b = {5,1,2,6,4,8,5};
        reOrderArray(a);
      System.out.println(Arrays.toString(a));

    }


    //插入排序
    public static void reOrderArray(int [] array) {
        for(int i = 0 ; i<array.length;i++){
            int temp = array[i];

            if((temp&1)==0){
                //偶数，位置不变
                continue;
            }
            else {

                int j = i - 1;
                while (j >= 0 && (array[j]&1)==0) {
                    array[j + 1] = array[j];
                    j--;
                }

                array[j + 1] = temp;
            }

        }

    }

    //插入排序
    public static void reOrderArray2(int [] array) {
             for(int i = 0 ; i<array.length;i++){
                 int temp = array[i];

                    int j = i-1;
                     while(  j>=0  && array[j]>= temp ) {
                         array[j+1] = array[j];
                         j--;
                     }

                     array[j+1] = temp;

             }

    }


}
