package Lecode;

import java.util.ArrayList;
import java.util.List;

public class _386_字典序排数 {

     public static void main(String[] args) {
         int n = 13;
         List<Integer> list = lexicalOrder2(n);
         System.out.println(list);
     }


    public static List<Integer> lexicalOrder2(int n) {
        List<Integer> result = new ArrayList<>();
        lexicalOrder(result,null,n);
        return result;
    }

    public static void lexicalOrder(List<Integer> result,Integer currentValue,int maxNum) {
        if(currentValue != null && currentValue > maxNum){
            return;
        }
        if(currentValue != null) {
            result.add(currentValue);
        }
        for(int nextBit = 0; nextBit <= 9;nextBit++){
            if(currentValue == null ){
                if(nextBit == 0) {
                    continue;
                } else {
                    currentValue = 0;
                }
            }
            lexicalOrder(result,currentValue*10+nextBit,maxNum);
        }
    }

    //==============================================================

    public static List<Integer> lexicalOrder(int n) {
         TridNode nodes = new TridNode();
         for(int i = 0 ; i < n ; i++){
             TridNode node = nodes;
             node = node.get(i%10);
             int j = i;
             while(j/10 != 0){
                 j = j/10;
                 node = node.get(j%10);
             }
         }

         ArrayList<Integer> list = new ArrayList<>();

        return  list;
    }

    //凉凉
    public static void dp(TridNode nodes){

         if(nodes.count==0){

         }

         while(nodes.count!=0){
             TridNode[] tridNodes = nodes.tridNodes;
             for(TridNode tr: tridNodes){

             }
         }


    }



    static class  TridNode{
         TridNode[] tridNodes;
         int count;

         TridNode(){
             tridNodes = new TridNode[10];
             count = 0;
         }

        public  TridNode get(int i) {
             if(tridNodes[i]!=null) {
                 return tridNodes[i];
             }
             else {
                 TridNode node = new TridNode();
                 tridNodes[i] = node;
                 count++;
                 return node;
             }

         }


    }
}
