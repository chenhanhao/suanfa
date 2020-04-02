package Lecode.二叉搜索树;

import Util.TreeNode;

public class _701_二叉树的插入操作 {
     public static void main(String[] args) {

     }

    public TreeNode insertIntoBST(TreeNode root, int val) {
       //找到空位置插入新结点
        if (root == null) return new TreeNode(val);

        if (root.val < val) {
            root.right =  insertIntoBST(root.right, val);
        }
        if (root.val > val) {
            root.left =  insertIntoBST(root.left, val);
        }
        return  root;


    }
}
