package Lecode.数组;

import java.util.ArrayList;
import java.util.List;

public class _54_螺旋矩阵 {
     public static void main(String[] args) {
         int[] a = {1};
         int[] b = {5,6,7,8};
         int[] c = {9,10,11,12};
         int [][] nums = {a};
         List<Integer> list = spiralOrder(nums);
         System.out.println(list.toString());

     }

    public static List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> list = new ArrayList<>();
        if(matrix.length==0){
            return list;
        }
        int row = matrix.length;//行
        int col = matrix[0].length;//列

        //设置4个边界
        int up = 0;
        int down = row-1;
        int left = 0;
        int right = col-1;



       //设置起点指针
       int x = 0;
       int y = 0;
       list.add(matrix[x][y]);

       while(up<down && left<right){

           //先向右走
           if(y<right ) {
               while (y < right) {
                   list.add(matrix[x][++y]);
               }
               up++;
           }
           if(up>down){
               break;
           }

           //向下走
           if(x<down ) {
               while (x < down) {
                   list.add(matrix[++x][y]);
               }

               right--;
           }
           if(left>right){
               break;
           }

           //向左走
           if(y>left ) {
               while (y > left) {
                   list.add(matrix[x][--y]);
               }

               down--;
           }
           if(up>down){
               break;
           }

           //向上走
           if(x>up ) {
               while (x > up) {
                   list.add(matrix[--x][y]);
               }
               left++;
           }
           if(left>right){
               break;
           }



       }
       return list;



    }
}
