package 算法小炒.算法框架;

import Util.TreeNode;

public class _2_二叉搜索树框架 {
     public static void main(String[] args) {


     }

    //验证二叉搜索树，将一个结点与其相邻的结点与父结点的极值做比较
    public boolean isValidBST(TreeNode root, TreeNode max, TreeNode min) {
        //构建框架，左边小于右边
        if(root==null) return true;

        if(max!=null && root.val >= max.val) return  false;
        if(min!=null && root.val <= min.val) return  false;

        return isValidBST(root.left,root,min) && isValidBST(root.right,max,root);

    }


     //验证二叉搜索树,左右节点比较
     public boolean isValidBST(TreeNode root) {
         //构建框架，左边小于右边
         if(root==null) return true;

         if(root.left!=null && root.left.val >= root.val) return false;
         if(root.right!=null && root.right.val <= root.val) return false;

         return isValidBST(root.left) && isValidBST(root.right);

     }

}
