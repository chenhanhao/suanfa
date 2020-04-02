package Lecode;

public class _892_三椎形的表面积 {
     public static void main(String[] args) {
         int[] a = {1,0};
         int[] b = {0,2};
         int[][] arr ={a,b};
         int i = surfaceArea(arr);
         System.out.println(i);

     }

    public static int surfaceArea(int[][] grid) {
         int rows = grid.length;//行
         int cols = grid[0].length;//列
         int sum = 0;

         for(int i = 0; i< rows ;i++){
             for(int j = 0; j< cols;j++){
                 int m =grid[i][j];
                 int n = 0;
                 if(m!=0) {
                     n = 4 * m + 2;
                 }



                 if(i-1 >=0 ){
                    n =  n-2*Math.min(grid[i-1][j],grid[i][j]);
                 }
                 if(j-1 >= 0 ){
                     n =  n-2*Math.min(grid[i][j-1],grid[i][j]);
                 }

                 sum += n;
             }


         }
         return  sum;

    }
}
