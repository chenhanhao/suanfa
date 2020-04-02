package Lecode.字符串;

public class _28_实现strStr {
     public static void main(String[] args) {
         int i = strStr("hello", "lo");
         System.out.println(i);

     }

    public static int strStr(String haystack, String needle) {
        int size = needle.length();
        if(size==0){
            return 0;
        }
        for(int i = 0; i <= haystack.length()-size; i++){

            if(needle.equals(haystack.substring(i,i+size))){
                return i;
            }
        }
        return -1;
    }
}
