package Lecode.二叉搜索树;

import Util.TreeNode;

public class _700_二叉搜索树的搜索 {
     public static void main(String[] args) {

     }

     //===二叉搜索树框架
    public TreeNode kuanjia(TreeNode root,int val){
        if (root.val == val) {
            // 找到目标，做点什么
            return root;
        }
        if (root.val < val) {
            return searchBST(root.right, val);
        }
        if (root.val > val) {
            return searchBST(root.left, val);
        }
        return  null;

    }

     //递归

    public TreeNode searchBST(TreeNode root, int val) {
           if(root==null || root.val == val) return root;

           if (root.val < val) {
               return searchBST(root.right, val);
           }
           if (root.val > val) {
               return searchBST(root.left, val);
           }
               return  null;


    }

    //迭代

    public TreeNode searchBST2(TreeNode root, int val) {
        while(root != null)
        {
            if(val < root.val)      root = root.left;
            else if(val > root.val) root = root.right;
            else                    return root;
        }
        return null;
    }


}
