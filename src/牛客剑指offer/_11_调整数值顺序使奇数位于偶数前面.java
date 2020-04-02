package 牛客剑指offer;

import java.util.Arrays;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
public class _11_调整数值顺序使奇数位于偶数前面 {

     public static void main(String[] args) {

         int[] a = {1,2,3,4,5,6,7};
         System.out.println(Arrays.toString(a));
         reOrderArray2(a);
         System.out.println(Arrays.toString(a));

     }


     //题目要求需要稳定排序使用插入排序的思想
        public  void reOrderArray(int [] array) {
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





     //使用双指针交换，快排思想，不稳定的一种思路
    public static void reOrderArray2(int [] array) {

        int left = 0;
        int right = left+1;
        int len = array.length;

        while( left<len){
            //找到偶数出现的下标
            while((array[left]&1)==1 && left<len){
                left++;
            }

            if(right >= len ){
                break;
            }
            right = left+1;
            //找到奇数下标
            while(right<len && ((array[right]&1)==0 )){
                right++;
            }
            System.out.println(left+"----"+right);
            if(right >= len ){
                break;
            }
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            left = left+1;

        }

    }
}
