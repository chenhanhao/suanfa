package Lecode;

import java.util.ArrayDeque;

public class _239_滑动窗口最大值 {

     public static void main(String[] args) {
         int[] nums = {1,3,-1,-3,5,3,6,7};
         int[] ints = maxSlidingWindow(nums, 3);


       for(int a: ints){
           System.out.println(a);
       }
     }



     //暴力
    public static  int[] maxSlidingWindow2(int[] nums, int k) {
        if(nums.length==0 || nums==null){
            return new int[0];
        }

       int[] res = new int[nums.length-k+1];
          for(int i = 0; i < nums.length-k+1;i++){
              int max = Integer.MIN_VALUE;
              for(int j = i; j<i+k;j++){
                  if(nums[j]> max){
                      max = nums[j];
                  }
              }

             res[i] = max;
          }

         return res;
     }


    public static  int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length==0 || nums==null){
            return new int[0];
        }


        //window存下标
        ArrayDeque<Integer> window = new ArrayDeque<Integer>(k);
        ArrayDeque<Integer> deq = new ArrayDeque<Integer>(k);
        int[] res = new int[nums.length-k+1];

        for(int j = 0 ; j < k-1 ;j++){
            //在加入数前，将其前面小的数删掉
            while (window.size()!=0) {
                if (nums[window.peek()] < nums[j]) {
                    window.pop();
                }
                else {
                    deq.addLast(window.pop());
                }
            }

            window = deq.clone();
            window.addLast(j);
            deq.clear();
        }

        for(int i = k-1 ; i < nums.length; i++){
            if(window.size()==0){
                window.addLast(i);
            }
            else {
                if (window.peek() <= i - k) {
                    window.pop();

                }
                    //在加入数前，将其前面小的数删掉
                    while (window.size()!=0) {
                        if (nums[window.peek()] < nums[i]) {
                            window.pop();
                        }
                        else {
                            deq.addLast(window.pop());
                        }
                    }

                    window = deq.clone();
                    window.addLast(i);
                    deq.clear();



            }
            res[i-k+1] = nums[window.peek()];
        }

     return res;

    }
     //错误的双端队列
    public static  int[] maxSlidingWindow3(int[] nums, int k) {
        if(nums.length==0 || nums==null){
            return new int[0];
        }

            //维护一个长度为k的队列
        //向队列中加入元素，比新加入的值还小的已在队列中的值出队
        //没加如一个值，则队列首部就是一个当前窗口的最大值

        //维护一个长度为k的队列
        //如何设置一个双端队列？有什么方法？
        ArrayDeque<Integer> deq = new ArrayDeque<Integer>(k);
        ArrayDeque<Integer> deq2 = new ArrayDeque<Integer>(k);

        //向队列中加入元素，比新加入的值还小的已在队列中的值出队
        int[] res = new int[nums.length-k+1];
        for(int j = 0 ; j < k-1 ;j++){
            while ( deq.size()!=0 ){

                if(deq.peek()<nums[j]){
                    deq.pop();
                }
                else{
                    deq2.addLast(deq.peek());
                    deq.pop();
                }

            }
            deq = deq2.clone();
            deq2.clear();

            deq.addLast(nums[j]);
        }

        for(int i = k-1 ; i< nums.length; i++){

            if(deq.size()==k ) {
                //如果队中的数量大于k则，需求把队首出队
                deq.pop();
            }

                //将数出去
            while ( deq.size()!=0 ){
                if(deq.peek()<nums[i]){
                    deq.pop();
                }
                else{
                    deq2.addLast(deq.peek());
                    deq.pop();
                }

            }
            deq = deq2.clone();
            deq2.clear();
                deq.addLast(nums[i]);
                res[i-k+1] = deq.peek();


        }
       return res;


    }
}
