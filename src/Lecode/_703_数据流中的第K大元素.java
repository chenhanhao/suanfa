package Lecode;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 设计一个找到数据流中第K大元素的类（class）。注意是排序后的第K大元素，不是第K个不同的元素。
 *
 * 你的 KthLargest 类需要一个同时接收整数 k 和整数数组nums 的构造器，它包含数据流中的初始元素。
 * 每次调用 KthLargest.add，返回当前数据流中第K大的元素。
 *
 */
public class _703_数据流中的第K大元素 {
     public static void main(String[] args) {
         int[] arr = {4,5,8,2,1};
         _703_数据流中的第K大元素 ll = new _703_数据流中的第K大元素(3,arr);
         System.out.println(ll.q.peek());

         PriorityQueue<Integer> qq = new PriorityQueue<Integer>();
         for(int num : arr){
             qq.add(num);

         }
         System.out.println(Arrays.toString(qq.toArray())+"-----");
        while (qq.size()>0){
            System.out.println(qq.poll());
        }



     }





    //设置一个优先队列
    int k;
    //设置一个优先队列，小顶堆，控制堆的长度大小
    private PriorityQueue<Integer> q;

    public _703_数据流中的第K大元素(int k, int[] nums) {
        this.k = k;
        q = new PriorityQueue<Integer>();
        for(int num : nums){
            add(num);
        }


    }

    public int add(int val) {
        if(q.size()< k ){
            q.add(val);
        }
        else if(val > q.peek()){
            q.poll();
            q.add(val);
        }
        return q.peek();

    }



    
}
