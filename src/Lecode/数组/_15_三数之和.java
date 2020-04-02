package Lecode.数组;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _15_三数之和 {
     public static void main(String[] args) {
         int[] arr = {-2,0,4,6,0,2,5,2};
         List<List<Integer>> lists = threeSum(arr);
         System.out.println(lists.toString());
     }

    /**
     * 双指针方法，左右指针扫描
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums.length==0){
            return result;
        }

        Arrays.sort(nums);

        for(int i = 0 ; i < nums.length ; i++){
            if(i>0  && nums[i]==nums[i-1]  ){
                continue;
            }
            int  temp = nums[i];
            int left = i+1;
            int right = nums.length-1;
            while(left < right){
                if(-temp == (nums[left] + nums[right])){
                    List<Integer> re = new ArrayList<>();
                    re.add(temp);re.add(nums[left]);re.add(nums[right]);
                    result.add(re);
                    left++; right--;


                    //已经有数进入结果了，需要遍历去重,因为排好序了，进行与隔壁比较就行
                    while(left < nums.length && nums[left]==nums[left-1] ) left++;
                    while( left< right && nums[right] == nums[right+1] ) right--;




                }
               else if(-temp < (nums[left]+ nums[right])){
                    right--;
                }
                else {
                    left++;
                }
            }

        }
        return result;

    }
}
