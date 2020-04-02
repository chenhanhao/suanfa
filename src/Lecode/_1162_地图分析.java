package Lecode;

import java.util.ArrayDeque;

/**
 * bfs层次遍历
 *
 *
 *
 */
public class _1162_地图分析 {
     public static void main(String[] args) {
         int[][] arr = {{1,0,1},{0,0,0},{1,0,1}};
         int i = maxDistance(arr);
         System.out.println(i);

     }

    public static  int maxDistance(int[][] grid) {
        ArrayDeque<int[]> queue = new ArrayDeque<>();//int[]数组存的是下标
        int row = grid.length;//行
        int col = grid[0].length;//列

        //把所以的陆地结点都加入到队列中
        for(int i = 0 ; i< row;i++){
            for(int j=0; j < col; j++ ){
                if(grid[i][j] == 1){
                    queue.add(new int[] {i,j});
                }
            }
        }

        // 如果我们的地图上只有陆地或者海洋，请返回 -1。
        if (queue.isEmpty() || queue.size() == row * col) {
            return -1;
        }



        //进行bfs遍历
        int depth = -1;
        while(!queue.isEmpty()){
            depth++;
            int n = queue.size();
            for(int i = 0 ; i< n; i++){
                int[] pop = queue.pop();
                int x = pop[0];
                int y = pop[1];
                //遍历这个结点的上下左右

                //先上
                if((x-1)>=0 && grid[x-1][y]==0){
                    grid[x-1][y]=2;
                    queue.add(new int[]{x-1,y});

                }

                //左
                if((y-1)>=0 && grid[x][y-1]==0){
                    grid[x][y-1]=2;
                    queue.add(new int[]{x,y-1});

                }


                //右
                if((y+1) < col  && grid[x][y+1]==0){
                    grid[x][y+1]=2;
                    queue.add(new int[]{x,y+1});

                }

                //下
                if((x+1) < row  && grid[x+1][y]==0){
                    grid[x+1][y]=2;
                    queue.add(new int[]{x+1,y});

                }

            }


        }

   return depth;

    }
}
