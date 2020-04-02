package 牛客剑指offer;

import java.util.ArrayList;

public class _27_和为S的连续正数序列 {
     public static void main(String[] args) {
         ArrayList<ArrayList<Integer>> arrayLists = FindContinuousSequence(3);
         System.out.println(arrayLists.toString());
         StringBuilder b = new StringBuilder();
         String a = "ddd";
         String[] s = a.split(" ");

         String cc = "student. a am I";
         String[] str = cc.split(" ");
         StringBuilder bu = new StringBuilder();
         for(String stt : str){
             StringBuilder str1 = new StringBuilder(stt);
             str1.reverse();
             bu.append(" ");
             bu.append(str1.toString());

         }


         System.out.println(bu.reverse().replace(bu.length()-1,bu.length()-1,""));

     }

    public static ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {

        ArrayList<ArrayList<Integer>>  lists = new ArrayList<>();
        for(int i = 1 ; i < sum ; i++){

            int res = 0;
            int temp = i;
            int index = i;
            while(res < sum){
                res = res+temp;
                index++;
                temp++;
            }
      //      System.out.println(res);
//            System.out.println(i);
//            System.out.println(index);
            if(res==sum){
                ArrayList<Integer> list = new ArrayList<>();
                for(int k = i ; k  < index ; k++){
                    System.out.println("加入"+k);
                    list.add(k);
                }
                lists.add(list);
            }

        }

        return lists;
    }
}
