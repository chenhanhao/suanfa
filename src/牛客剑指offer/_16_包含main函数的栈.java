package 牛客剑指offer;

import java.util.Stack;

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 */
public class _16_包含main函数的栈 {





}

class Solution {
    private int min = Integer.MAX_VALUE;
    //普通栈
    Stack<Integer> stack1 = new Stack();
    //最小值栈
    Stack<Integer> stack2 = new Stack();


    public void push(int node) {
        //将最小值，压入栈
         if(node<=min){
             min = node;
             stack2.push(node);
         }

         //将值压入普通栈
         stack1.push(node);
    }

    public void pop() {
        //每次在出栈的时候，判断，出栈的数与当前最小栈的数是否相同，
        // 相同的话，需要将最小栈中的值弹出，同时修改最小值为此时最小栈
        //的栈顶

        if(stack1.size()==0){
            return;
        }
        Integer pop = stack1.pop();

        if(stack2.size()!=0) {

            if (pop == stack2.peek()) {
                stack2.pop();
                min = stack2.peek();
            }
        }

    }

    public int top() {
       return  stack1.peek();
    }

    public int min() {
        return min;
    }
}


