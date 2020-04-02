package 牛客剑指offer;

/**
 * 数组中只出现一次的数字
 * 一个整型数组里除了两个数字之外，
 * 其他的数字都出现了两次。请写程序找出这两个只出现一次的数字
 *
 * 思路： 一个数与0进行异或，会得到其本身
 * 两个相同的数进行异或得到0
 * 所以，先将数组中的每一个数进行异或，最后的结果则为所求A，B互相异或的结果
 * 那么，我们取结果的从右到左的第一个二进制1，说明，这个位置上面A与B是不相同的，
 * 将数组根据这个位置分割为两段，再次根据一开始的思路进行异或0，得到两个结果
 */


public class _26_数组中只出现一次的数字 {
     public static void main(String[] args) {

            int[] arr = {1,1,2,2,3,4,4,5,5,6,9,9};
            int[] a = new int[1];
            int[] b = new int[1];

         FindNumsAppearOnce(arr,a,b);
         System.out.println(a[0]+"---"+b[0]);
     }

      public  static  void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {

         int result = 0;

         //将数组依次进行异或
         for(int i = 0 ; i<array.length ; i++){
             result =  result ^ array[i];
         }
         System.out.println(result);

         //如何将一个数转为二进制？
          //与1进行与,找出第一个1的下标
         //找出断开点
          int index = 1;
          while((index & result)==0){
              index <<= 1;
          }
          System.out.println(index);

          //分组
          int result1 = 0;
          int result2 = 0;

          for(int i = 0 ; i< array.length; i++){
              if((array[i] & index) ==0 ){
                  result1 = result1 ^ array[i];
              }
              else {
                  result2 = result2 ^ array[i];
              }
          }

          num1[0] = result1;
          num2[0] = result2;





    }


}
