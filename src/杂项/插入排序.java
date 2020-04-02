package 杂项;

import java.util.Arrays;

/**
 * 将数组分为两部分，一部分为已排序数组，另一部分是未排序数组
 *
 */
public class 插入排序 {

     public static void main(String[] args) {

         int[] a = {2,56,9,8,24,5,1,2};
         reOrderArray2(a);
         System.out.println(Arrays.toString(a));
     }

    public static void insertSort(int[] array) {
        int i,j,temp;
        for(i=1;i<array.length;i++) {
            temp=array[i];
            for(j=i-1;j>=0;j--) {
                if(temp>array[j]) {
                    break;
                }else {
                    array[j+1]=array[j];
                }
            }
            array[j+1]=temp;
        }
        System.out.println(Arrays.toString(array));
    }


    //插入排序
    public static void reOrderArray2(int [] array) {
        for(int i = 0 ; i<array.length;i++){
            int temp = array[i];

            int j = i-1;
            while(  j>=0  && temp<array[j] ) {
                array[j+1] = array[j];
                j--;
            }

            array[j+1] = temp;

        }

    }

}
