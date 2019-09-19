package 牛客剑指offer;

import java.util.Arrays;

public class _1_二维数组中查找 {
     public static void main(String[] args) {
          int[][] a = new int[4][4];
          for(int i= 0; i<4 ; i++){
               int k = i+1;
               for (int j= 0; j<4 ;j++){
                    a[i][j] = k;
                    k=k+2;
               }
          }

          System.out.println(Find(12, a));


         for (int[] b: a){
              System.out.println(Arrays.toString(b));
         }
     }

     //使用矩阵向下搜索
     //那么选取右上角或者左下角的元素a[row][col]与target进行比较，
     public static boolean Find(int target, int[][] array) {

               int row=0;
               int col=array[0].length-1;
               while(row<=array.length-1&&col>=0){
                    if(target==array[row][col])
                         return true;
                    else if(target>array[row][col])
                         row++;
                    else
                         col--;
               }
               return false;

          }




     //使用二分查找遍历数组
     public boolean Find(int [][] array,int target) {

          for(int i=0;i<array.length;i++){
               int low=0;
               int high=array[i].length-1;
               while(low<=high){
                    int mid=(low+high)/2;
                    if(target>array[i][mid]) {
                         low = mid + 1;
                    }
                    else if(target<array[i][mid]) {
                         high = mid - 1;
                    }
                    else
                         return true;
               }
          }
          return false;

     }
}
