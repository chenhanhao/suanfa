package Lecode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class _820_单词的压缩编码 {
     public static void main(String[] args) {

         String[] arr = {"time", "me", "bell"};
         int i = minimumLengthEncoding(arr);
         System.out.println(i);
     }

     //存储数据
    public static int minimumLengthEncoding2(String[] words) {
        Set<String> set  = new HashSet<>(Arrays.asList(words));

        for(int i = 0 ; i < words.length; i++){
            for(int j = 1 ; j<words[i].length();j++){
                if(set.contains(words[i].substring(j))){
                    set.remove(words[i].substring(j));
                    break;
                }
            }
        }

         int ans = 0;
         for(String word:set){
             ans += word.length() + 1;
         }

        return ans;

    }

    //============================================================================================
    //使用字典树的方式
    public static int minimumLengthEncoding(String[] words) {
         //将节点存入一个map中
         HashMap<TrieNode,Integer> map = new HashMap<>() ;

         TrieNode nodes = new TrieNode();

         for(int i = 0; i< words.length; ++i){
             TrieNode trieNode = nodes;
             for(int j = words[i].length()-1; j>=0 ; --j){
                  trieNode = trieNode.get(words[i].charAt(j));
             }

             map.put(trieNode,i);

         }

        int ans = 0;
        for (TrieNode node: map.keySet()) {
            if (node.count == 0)
                ans += words[map.get(node)].length() + 1;
        }
        return ans;



    }



    //倒着插入数据，字典树.a,b,c,d
    static class  TrieNode{
         TrieNode[] children;
         int count;
         TrieNode(){
             children = new TrieNode[26];
             count = 0;
         }

         public TrieNode get(char c){
             if (children[c - 'a'] == null) {
                 children[c - 'a'] = new TrieNode();
                 count++;
             }
             return children[c - 'a'];

         }

    }
}
