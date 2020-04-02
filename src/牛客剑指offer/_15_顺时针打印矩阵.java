package 牛客剑指offer;

import java.util.ArrayList;

/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字
 * ，例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */

public class _15_顺时针打印矩阵 {
     public static void main(String[] args) {
          int[][] arr = new int[4][4];
          int k = 0;
          for(int i = 0 ; i< 4; i++){
               for(int j =0 ; j<4 ;j++){
                    arr[i][j] = k;
                    k++;
               }

          }

//          for (int[] b : arr) {
//               System.out.println(Arrays.toString(b));
//
//          }

          int[] a = {1,2,3,4};
          int[] b = {5,6,7,8};
          int[] c = {9,10,11,12};
          int [][] nums = {a,b,c};

          System.out.println(printMatrix(nums));
     }

     //打印矩阵
     public static ArrayList<Integer> printMatrix(int [][] matrix) {
         //定义4个边界
          int up = 0;
          int down = matrix.length-1;
          int left = 0;
          int right = matrix[0].length-1;

          ArrayList<Integer> arrayList = new ArrayList<>();

          while(true){

               //向右走
               for(int i = left ; i<=right; i++){
                    arrayList.add(matrix[up][i]);
               }
               up++;
               //对越界结束
               if(up>down){
                    break;
               }

               //向下走
               for(int i = up; i<=down;i++){
                    arrayList.add(matrix[i][right]);
               }

               right--;
               //对越界判断
               if(right<left){
                    break;
               }

               //向左走
               for(int i = right; i>=left;i--){
                    arrayList.add(matrix[down][i]);
               }
               down--;

               if(down<up){
                    break;
               }

               //向上走
               for(int i = down; i>=up; i--){
                    arrayList.add(matrix[i][left]);
               }

               left++;

               if(left>right){
                    break;
               }

          }

          return arrayList;

     }


}
