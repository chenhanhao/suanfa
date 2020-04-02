package Lecode;

import java.util.Arrays;

public class _912_排序数组 {
     public static void main(String[] args) {
         int[] a = {4,6,2,1,4,6};
         sortArray(a,0,a.length-1);
         System.out.println(Arrays.toString(a));
     }

    public static void sortArray(int[] a, int left , int right){
        //递归结束条件
        if(left>=right){
            return ;
        }
        //找到基准
        int patten = patten(a, left, right);
        //左边排序
        sortArray(a,left,patten-1);

        //有有右边排序
        sortArray(a,patten+1,right);

    }


    //分治，双向循环
    // 找出基准的下标
    public static int patten(int[] a, int start ,int end) {
        //双向指针
        int left = start;
        int right = end;
        int temp = a[start]; //这里默认使用数组开头的第一个数做为基准

        while (left != right) {
            //必须右边针先移，为什么？？？因为如果没有先控制右边的过来，会导致，交换的值
            //left 跳到大的一部分，导致排序有误差
            //为什么要小于或者等于，控制指针左移动
            while (a[right] > temp && left < right) {
                right--;
            }

            //控制left指针，右移，a[left] 必须<=，不然出现有与temp一样的值会出现死循环，必须         索引值都
            //扫描到
            while (a[left] <= temp && left < right) {
                left++;
            }

            if (left < right) {
                int temp2 = a[right];
                a[right] = a[left];
                a[left] = temp2;
            }
        }
        //pivot 和指针重合点交换
        // int pivote = a[left];
        a[start] = a[left];
        a[left] = temp;
        return left;
    }

}
