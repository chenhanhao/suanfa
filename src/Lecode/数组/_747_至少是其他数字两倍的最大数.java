package Lecode.数组;

public class _747_至少是其他数字两倍的最大数 {
     public static void main(String[] args) {
       int[] a = {0,0,0,1};
       System.out.println(dominantIndex(a));

     }


        public int dominantIndex2(int[] nums) {
            int maxIndex = 0;
            for (int i = 0; i < nums.length; ++i) {
                if (nums[i] > nums[maxIndex])
                    maxIndex = i;
            }
            for (int i = 0; i < nums.length; ++i) {
                if (maxIndex != i && nums[maxIndex] < 2 * nums[i])
                    return -1;
            }
            return maxIndex;
        }


    public static int dominantIndex(int[] nums) {
        //线性扫描
        int max = -1;
        int index = 0;
        for(int i = 0 ; i < nums.length; i++){
            if(nums[i] > max ){
                max = nums[i];
                index = i;
            }
        }

        for(int i = 0 ; i < index; i ++){
            if(max < nums[i]*2){
                return -1;
            }
        }
        for(int i = index+1 ; i < nums.length; i ++){
            if(max < nums[i]*2){
                return -1;
            }
        }
        return index;
    }
}