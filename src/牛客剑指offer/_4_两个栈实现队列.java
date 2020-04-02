package 牛客剑指offer;

/**
 * @author ASNPIHA
 * @date 2019-12-16 5:21 PM
 */

import java.util.Stack;

/**
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型
 */
public class _4_两个栈实现队列 {
    public static  void main(String[] args) {
        queue queue = new queue();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.push(4); queue.push(5);
        for (int i = 0 ; i<4;i++){
            System.out.println( queue.pop());

        }



    }


  static class queue{


       Stack<Integer> stack1 = new Stack<Integer>();
       Stack<Integer> stack2 = new Stack<Integer>();


       public void push(int node) {
           stack1.add(node);
       }

       public int pop() {
           if(!stack2.isEmpty()){
               return stack2.pop();
           }
           else {
               while(!stack1.isEmpty()){
                   stack2.add(stack1.pop());
               }
               return stack2.pop();
           }
       }
   }
}


