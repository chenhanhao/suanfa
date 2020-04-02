package 牛客剑指offer;

/**
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 * 输入描述:
 * 二叉树的镜像定义：源二叉树
 *     	    8
 *     	   /  \
 *     	  6   10
 *     	 / \  / \
 *     	5  7 9 11
 *     	镜像二叉树
 *     	    8
 *     	   /  \
 *     	  10   6
 *     	 / \  / \
 *     	11 9 7  5
 */
public class _14_二叉树的镜像 {

     public static void main(String[] args) {

     }

     //先得有可以互换一个结点的左右节点的方法

     public void Mirror(TreeNode root) {
         if(root==null){
             return;
         }

         else{
             //交换
             TreeNode temp = root.left;
             root.left = root.right;
             root.right = temp;


             Mirror(root.left);
             Mirror(root.right);
             return;
         }

     }




    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }
}
