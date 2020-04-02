package 牛客剑指offer;

/**
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 */

/**
 *   // 被覆盖的目标矩形的形状： 2*n
 *          // 每次新增加的一列，（1）如果竖着放对应的情况与 target为 n-1 时相同；
 *          // （2如果横着放，对应的情况与 target 为 n-2 时相同。
 */
public class _8_矩形覆盖 {
     public static void main(String[] args) {
         System.out.println(RectCover(6));

     }

     public static int RectCover(int target) {


         if(target <=2){
             return target;
         }else{
             return RectCover(target-1) + RectCover(target-2);
         }
     }

}



