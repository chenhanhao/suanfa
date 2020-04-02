package Lecode;

public class _289_生命游戏 {
     public static void main(String[] args) {

     }

    public void gameOfLife(int[][] board) {
         //该数组用于访问结点的周围8个位置
         int [] arr = {0,1,-1};
         //复制一个数组
        int rows = board.length;//行
        int cols = board[0].length;//列
        int[][] copy = new int[rows][cols];

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                copy[i][j] = board[i][j];
            }
        }


    }
}
