package Lecode.栈;

import java.util.HashMap;
import java.util.Stack;

public class _20_有效的括号 {
     public static void main(String[] args) {
         boolean valid = isValid("{[]}");
         System.out.println(valid);

     }

    public static boolean isValid(String s) {
         if(s.isEmpty()){
             return true;
         }

        HashMap map = new HashMap();
        map.put(')','(');
        map.put(']','[');
        map.put('}','{');
        char[] arr = s.toCharArray();
        Stack<Character> st = new Stack<>();
       for(int i = 0 ; i <arr.length; i++){
           if(arr[i] == ')' || arr[i] == ']' || arr[i] == '}'){
               if(!st.isEmpty() && st.peek()==map.get(arr[i])){
                   st.pop();
                   continue;
               }
               else {
                   return false;
               }

           }
           st.push(arr[i]);

       }

       return st.isEmpty();
    }

}
