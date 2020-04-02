package Lecode.数组;

public class _724_寻找数组的中心索引 {
     public static void main(String[] args) {
        int[] a = {1,2,3,4,6};
        System.out.println( pivotIndex(a));


     }


  //代码优化
    public static  int pivotIndex(int[] nums) {
          int sum = 0;
          for(int i = 0 ; i<nums.length; i++){
              sum += nums[i];

          }
          for(int i = 0 ; i < nums.length; i++){
               int left = 0;
               if(left== sum-left-nums[i]){
                   return i;
               }
              left += nums[i];
          }
          return -1;

    }


    public static  int pivotIndex2(int[] nums) {

         int sum = 0;
      for(int i = 0 ; i < nums.length ; i++){

          if( i-1 !=-1){
              sum = sum + nums[i-1];
          }

          int sum2 = 0;
          for(int j = i+1; j<nums.length; j++ ){
              sum2 = sum2 + nums[j];
          }

          if(sum2 == sum ){
              return i;
          }


      }

        return -1;

    }
}
