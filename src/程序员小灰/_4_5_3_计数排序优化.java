package 程序员小灰;

import java.util.Arrays;

/**
 * 计数排序优化，稳定排序
 */
public class _4_5_3_计数排序优化 {

     public static void main(String[] args) {
       int[] arr = {92,96,93,94,96,92,94,93,91,90};
         countSort(arr);
     }


    public static int[] countSort(int[] arrays){
        //1,得到最大值与最小值，并计算出差值d

        int min = arrays[0];//最小值
        int max = arrays[0];//最大值
        int d = 0;//差值

        for (int i = 0; i<arrays.length; i++){
             if(arrays[i]>max){
                 max=arrays[i];
             }

             if(arrays[i]<min){
                 min = arrays[i];
             }
        }

        d = max - min;

        //2，创建统计数组，并统计出对应元素的个数
        int [] counntArray = new int[d+1];
        for(int i = 0; i<arrays.length; i++){
            counntArray[arrays[i]-min]++;
        }

        System.out.println(Arrays.toString(counntArray));



        //3，统计数组做变形，后面的元素等于前面的元素之和

        for (int i = 1; i<counntArray.length;i++){
            counntArray[i] += counntArray[i-1];
        }




        System.out.println(Arrays.toString(counntArray));


        //4，倒序遍历数组，从统计数组找到正确位置，输出到结果数组
        int sortedArray[] = new int[arrays.length];
        for (int i =arrays.length-1 ;i>=0; i--){
             sortedArray[counntArray[arrays[i]-min]-1] = arrays[i] ;
            counntArray[arrays[i]-min]--;
        }

        System.out.println(Arrays.toString(sortedArray));

        return null;

    }


}
