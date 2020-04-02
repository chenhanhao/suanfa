 package Lecode.数组;

import java.util.Arrays;

public class _498_对角线遍历 {
     public static void main(String[] args) {
         int[] a = {1,2,3};
         int[] b = {4,5,6};
         int[] c = {7,8,9};
         int [][] nums = {a,b,c};
         int[] diagonalOrder = findDiagonalOrder(nums);
         System.out.println(Arrays.toString(diagonalOrder));

     }

    public static int[] findDiagonalOrder(int[][] matrix) {
         if(matrix.length==0){
             return new int[0];
         }


        int row = matrix.length-1;//行
        int col = matrix[0].length-1;//列
        int len = (row+1)*(col+1);
        int[] res = new int[len];
        int index = 0;

        /**
         * 只会有两种移动，左下 row--，col++
         * ，右上 row++ , col--
         */

        int x = 0;//对应row
        int y = 0;//对应col
        res[index] = matrix[x][y];
          while(x!=row || y!= col){
            //先右上
              while (true) {

                  if (x - 1 >= 0 && y + 1 <= col) {
                      //可以右上
                      index++;
                      res[index] = matrix[--x][++y];
                      if(x==row && y== col){
                          break;
                      }

                  } else {
                      //不可以右上,看看能不能右移
                      if (y + 1 <= col) {
                          index++;
                          res[index] = matrix[x][++y];
                          break;

                      }
                      //看看能不能下移
                      if (x+1 <= row) {
                          index++;
                          res[index] = matrix[++x][y];
                          break;

                      }



                  }
              }


              while (true) {
                  if(x==row && y== col){
                      break;
                  }

                  //再左下
                  if (y - 1 >= 0 && x + 1 <= row) {
                      //可以左下
                      index++;
                      res[index] = matrix[++x][--y];

                  } else {
                      //看看能不能下移
                      if (x+1 <= row) {
                          index++;
                          res[index] = matrix[++x][y];
                          break;

                      }
                      //不可以左下,看看能不能右移
                      if (y + 1 <= col) {
                          index++;
                          res[index] = matrix[x][++y];
                          break;
                      }



                  }
              }

          }


    return res;


    }

}
