package 牛客剑指offer;

import java.util.Stack;

/**
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。假设压入栈的所有数字均不相等。
 * 例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，
 * 但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
 */
public class _17_栈的出入顺序 {
     public static void main(String[] args) {


          int[] a = {1,2,3,4,5};
          int[] b = {4,5,3,2,1};
          int[] c = {4,3,5,1,2};
          System.out.println(IsPopOrder(a,c));

     }


    public static boolean IsPopOrder(int[] pushA, int[] popA) {
         //初始化一个栈
        Stack<Integer> stack = new Stack();

        //压栈操作，比较，遇到与出栈顺序相同的数，则出栈
        int out = 0;//记录出栈数组的位置
        for(int i = 0; i< popA.length;i++){
            //首先，先压入数；
               stack.push(pushA[i]);
              if(pushA[i]==popA[out] ){
                  //遇到与出栈相同的数，则弹出
                 stack.pop();
                 out++;
              }
        }

        //依次从出栈数组的位置，弹出比较
        for(int j = out ; j<popA.length;j++){
            if(popA[j]!=stack.pop()){
                return false;
            }

        }
        return true;

    }
}
