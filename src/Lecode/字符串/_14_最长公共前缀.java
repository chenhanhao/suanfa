package Lecode.字符串;

public class _14_最长公共前缀 {
     public static void main(String[] args) {
           String[] str ={"aa","a"};
         String s = longestCommonPrefix(str);
         System.out.println(s);

     }

    public static String longestCommonPrefix(String[] strs) {
        if(strs.length==0){
            return "";
        }
         StringBuilder res = new StringBuilder();
         for(int i=0; i < strs[0].length(); i++){
             char temp = strs[0].charAt(i);
             int j = 1;
             boolean flag = true;
             while(j<strs.length){
                 if(i>=strs[j].length() ||  strs[j].charAt(i)!=temp){
                    flag = false;
                    break;
                 }
                 j++;
             }
             if(flag==true){
                 res.append(temp);
             }
             else {
                 break;
             }

         }
         return res.toString();
    }
}
