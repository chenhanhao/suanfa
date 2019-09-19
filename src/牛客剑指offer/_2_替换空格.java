package 牛客剑指offer;

import java.util.ArrayList;

public class _2_替换空格 {


    public static void main(String[] args) {
           String a = "we  ad ad";
           StringBuffer aa = new StringBuffer();
         ArrayList<Integer> list = new ArrayList();

         //listNode node = listNode.next;

         char[] chars = a.toCharArray();
      for (int i= 0; i<chars.length;i++){
          if(chars[i]==' '){
             aa.append("%20");
          }
          else {
              aa.append(chars[i]);
          }
      }

        System.out.println(aa);
      ArrayList<Integer> ll = new ArrayList<>();
        //int[] j  = {1,2,3};
      ll.add(1);
        ll.add(2);
      System.out.println(ll.toString());


     }
}
