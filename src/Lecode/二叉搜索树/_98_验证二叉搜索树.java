package Lecode.二叉搜索树;

import Util.TreeNode;

public class _98_验证二叉搜索树 {
    public boolean isValidBST(TreeNode root){
        return isValidBST(root,null,null);
    }

    //验证二叉搜索树,保留结点的上下界
    public boolean isValidBST(TreeNode root, TreeNode max, TreeNode min) {
        //构建框架，左边小于右边
        if(root==null) return true;

        if(max!=null && root.val >= max.val) return  false;
        if(min!=null && root.val <= min.val) return  false;

        return isValidBST(root.left,root,min) && isValidBST(root.right,max,root);

    }
}
