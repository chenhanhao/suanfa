package Lecode.数组;

import java.util.ArrayList;
import java.util.List;

public class _118_杨辉三角 {
     public static void main(String[] args) {

         List<List<Integer>> generate = generate(5);
         System.out.println(generate.toString());
     }

    public static List<List<Integer>> generate(int numRows) {
         List<List<Integer>> lists = new ArrayList<>();
           for(int i = 0; i < numRows; i++){
               ArrayList<Integer> list = new ArrayList<>();
               if(lists.size()!=0){
                   List<Integer> lastlist = lists.get(lists.size() - 1);
                   list.add(1);
                   for(int j = 1; j < i  ; j++){
                       list.add(lastlist.get(j-1)+lastlist.get(j));
                   }
                   list.add(1);

               }
               else{
                   list.add(1);
               }
               lists.add(list);

           }
           return lists;
    }
}
