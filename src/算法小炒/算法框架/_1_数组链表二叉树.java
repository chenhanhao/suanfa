package 算法小炒.算法框架;

import Util.ListNode;
import Util.NTreeNode;
import Util.TreeNode;

public class _1_数组链表二叉树 {
     public static void main(String[] args) {


     }

     //数组 线性迭代结构
    public void suzhu(int[]arr){
         for(int i = 0; i< arr.length; i++){
             //迭代访问arr[i]
         }

    }

 //=======================================================
    //链表遍历框架,兼具迭代和递归结构：
    ListNode listNode = new ListNode(1);//结点类

     public void lianbiao(ListNode head){
        for(ListNode p = head; p!=null; p=p.next){
            //迭代访问 p.val
        }
     }

     public void lianbiao2(ListNode head){
         //递归访问head.val
         lianbiao2(head.next);

     }


     //================================================================
    //二叉树遍历框架爱
    TreeNode treeNode = new TreeNode(1);//结点类

    public void twotree(TreeNode root){
        twotree(root.left);
        twotree(root.right);
    }


    //========================================
    //n叉树遍历
  NTreeNode nTreeNode = new NTreeNode(1);

    public void ntree(NTreeNode root ){
        for(NTreeNode child: root.children){
            ntree(child);
        }
    }

}
