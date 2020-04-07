package Lecode;

public class _289_生命游戏 {
     public static void main(String[] args) {
         int[] a = {0,1,0};
         int[] b = {0,0,1};
         int[] c = {1,1,1};
         int[] d = {0,0,0};
         int[][] arr = {a,b,c,d};
         gameOfLife(arr);
         System.out.println(arr);


     }

    public static void gameOfLife(int[][] board) {
         //该数组用于访问结点的周围8个位置
         int [] arr = {0,1,-1};
         //复制一个数组
        int rows = board.length;//行
        int cols = board[0].length;//列
        int[][] copy = new int[rows][cols];

        //数组复制
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                copy[i][j] = board[i][j];
            }
        }

        //遍历数组中的每一个数
        for(int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int livenum = 0;
                //遍历8个位置，统计存活数
                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        //需要去掉（0,0）情况，这个情况就是数组本身，不用管
                        if (!(arr[k] == 0 && arr[l] == 0)) {
                            int x = i + arr[k];
                            int y = j + arr[l];

                            //判断越界与存活
                            if ((x<rows && x>=0) && (y<cols && y>=0) && (copy[x][y]==1)){
                                livenum++;
                            }
                        }

                    }
                }


                //分析规则
                //目标点存户
                if((copy[i][j] == 1) && (livenum<2 || livenum>3)) {
                    board[i][j] = 0;
                }
                if((copy[i][j] == 0) && livenum==3) {
                    board[i][j] = 1;
                }
            }
        }



    }
}
