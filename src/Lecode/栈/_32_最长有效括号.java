package Lecode.栈;

import java.util.Stack;

public class _32_最长有效括号 {

     public static void main(String[] args) {
         int i = longestValidParentheses("(()");
         System.out.println(i);
     }
     //============================================================================

     //堆栈法,存数组下标
     public static int longestValidParentheses(String s) {
         if(s.isEmpty()){
             return 0;
         }

         Stack<Integer> st = new Stack<>();
         st.push(-1);
         int max = 0;

         char[] chars = s.toCharArray();
         for(int i = 0 ; i< chars.length; i++){
             if(chars[i] == '('){
                 st.push(i);
             }
             else {
                 st.pop();
                 if(st.isEmpty()){
                     st.push(i);
                 }
                 else {
                     max = Math.max(max,i-st.peek());
                 }

             }
         }

         return max;

     }




     //暴力法 ================================================================
    public static int longestValidParentheses2(String s) {
        if(s.isEmpty()){
            return 0;
        }
        //两两想找
        int num = 0;

        for(int i = 2 ; i<=s.length(); i = i+2  ){
              for(int j = 0; j+i<= s.length(); j++){
                  if(check(s.substring(j,j+i))){
                      num = i;
                      break;
                  }
              }
        }

        return num;

    }

    public static boolean check(String s){
        char[] chars = s.toCharArray();
        Stack<Character> st = new Stack<>();
        for(int i = 0 ; i < chars.length; i++){
            if(chars[i]=='('){
                st.push('(');
            }
            else {
                if(!st.isEmpty() && st.pop() == '('){
                    continue;
                }
                else {
                    return false;
                }
            }
        }

        return st.isEmpty();
    }


}
