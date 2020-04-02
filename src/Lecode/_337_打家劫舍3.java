package Lecode;

import Util.CreatTreeNode;
import Util.TreeNode;

public class _337_打家劫舍3 {
     public static void main(String[] args) {
         int[] arr = {3,4,5,7,4};
         TreeNode tree = CreatTreeNode.getTree(arr);
         System.out.println(tree.val);
     }

    public int rob(TreeNode root) {
        return 1;


    }

    public static int deep(TreeNode node){
         if(node.left == null && node.right == null){
             return node.val;

         }
         else {
             int left = deep(node.left);
             int right = deep(node.right);
             return  Math.max(Math.max(left,right), node.val);
         }

    }
}
