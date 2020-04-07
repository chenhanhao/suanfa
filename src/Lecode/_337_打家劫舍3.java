package Lecode;

import Util.CreatTreeNode;
import Util.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class _337_打家劫舍3 {
     public static void main(String[] args) {
         int[] arr = {3,4,5,7,4};
         TreeNode tree = CreatTreeNode.getTree(arr);
         System.out.println(tree.val);
     }


    Map<TreeNode, Integer> map = new HashMap<>();
    public  int rob(TreeNode root){
          if(root==null){
              return 0;
          }
          if(map.containsKey(root)){
              return map.get(root);
          }

          //抢，然后去下下家
         int doit =root.val +( root.left==null? 0: rob(root.left.left)+ rob(root.left.right))
                 + (root.right==null? 0: rob(root.right.left)+ rob(root.right.right));

          //不抢，去下家
          int nodoit = rob(root.left) + rob(root.right);
          int re = Math.max(doit,nodoit);

          map.put(root,re);

          return re;

    }

}
