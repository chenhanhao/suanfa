package 牛客剑指offer;

/**
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
 */

import java.util.ArrayList;

/**
 * 提出问题：
 * 如何遍历一课二叉搜索树，且要求排好序---中序遍历
 * 那如何进行中序遍历？两种，递归与非递归
 *
 */
public class _21_二叉搜索树与双向链表 {
     public static void main(String[] args) {
         TreeNode node = new TreeNode(10);
         TreeNode node1 = new TreeNode(6);
         TreeNode node2 = new TreeNode(14);
         TreeNode node3 = new TreeNode(3);
         TreeNode node4 = new TreeNode(8);
         TreeNode node5 = new TreeNode(11);
         TreeNode node6 = new TreeNode(15);
         node1.left = node3;
         node1.right = node4;
         node2.left = node5;
         node2.right = node6;
         node.left = node1;
         node.right = node2;
         middle(node);
         System.out.println(list.toString());

     }

//    public TreeNode Convert(TreeNode pRootOfTree) {
//
//    }

    ///先写以可以中序遍历二叉搜索树的方法
    static ArrayList list= new ArrayList();

    public static void  middle(TreeNode node){
        //找出口
        if(node == null){
            return;
        }
        else{
            //通过递归进行遍历
            middle(node.left);
            list.add(node.val);
            middle(node.right);

        }
    }

}



class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}