package 八大排序.插入排序;

import java.util.Arrays;

/**
 * 插入排序的基本方法是：每一步将一个待排序的元素，按其排序码的大小，插入到前面已经排好序的一组元素的适当位置上去，直到元素全部插入为止。
 */

public class 直接插入排序 {


        public static void main(String[] args) {

            int arr[] = {2,1,5,3,6,4,9,8,7};

            int temp;

            for (int i=1;i<arr.length;i++){

                //待排元素小于有序序列的最后一个元素时，向前插入
                if (arr[i]<arr[i-1]){
                    temp = arr[i];
                    for (int j=i;j>=0;j--){
                        if (j>0 && arr[j-1]>temp) {
                            arr[j]=arr[j-1];
                        }else {
                            arr[j]=temp;
                            break;
                        }
                    }
                }
            }

            System.out.println(Arrays.toString(arr));

        }



}
