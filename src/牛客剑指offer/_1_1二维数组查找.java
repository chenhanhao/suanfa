package 牛客剑指offer;

/**
 * @author ASNPIHA
 * @date 2019-12-1n 11:24 AM
 */

import java.util.Random;

/**
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数
 */
public class _1_1二维数组查找 {
    public static void main(String[] args) {

        int[][] array = getArray(6, 7);

        System.out.println(Find2(8, array));


    }

    public static int[][] getArray(int n, int m){
       //n代表行数，m为列数
        int [][] arr = new int[n][m];
        //初始化第一行
        arr[0][0] = new Random().nextInt(n)+1;
        for(int i = 1 ; i<m;i++){
            arr[0][i] = arr[0][i-1]+new Random().nextInt(n)+1;
        }

        //初始化第一列
        for(int j=1; j<n;j++){
            arr[j][0] =arr[j-1][0]+new Random().nextInt(n)+1;
        }

        //让接下来的每一个数都等于他时正上或者左边两者中较大者，再加上随机数
        for(int k = 1 ;k <n;k++) {
            for(int j = 1; j<m;j++){
                arr[k][j] = Math.max(arr[k-1][j],arr[k][j-1]) + new Random().nextInt(n)+1;
            }
        }


        //打印出改数组
        for (int i = 0; i<n ;i++){
            for(int j = 0; j<m;j++){
                System.out.print(arr[i][j]+"  ");
            }
            System.out.println();
        }

        return arr;
    }

    //使用矩阵向下搜索
    //那么选取右上角或者左下角的元素a[row][col]与target进行比较，
    public static boolean Find2(int target, int[][] array) {

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

    public static boolean Find(int target, int [][] array) {
        int line = array.length;//行,6
        int row =  array[0].length;//列,7

        int i = 0;
        int j = 0;

        //对列判断,行固定
        while(array[line-1][i] < target && i<row) {
             i++;
        }

        if(i==row){
            return false;
        }

        //对行判断，列固定
        while(array[j][row-1] < target && j<line) {
            j++;
        }

        if(j==line){
            return false;
        }

        System.out.println(i+"---"+j);
        for(int k = i ; k<row;k++){
            for(int l = j; l<line;l++){
                if(array[k][l]==target){

                    System.out.println(target);
                    System.out.println(k+"---"+l);
                    return true;
                }

            }
        }

    return false;

    }
}
