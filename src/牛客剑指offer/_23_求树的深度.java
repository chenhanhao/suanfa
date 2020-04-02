package 牛客剑指offer;

/**
 * 输入一棵二叉树，求该树的深度。
 * 从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度
 */
public class _23_求树的深度 {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(6);
        TreeNode node6 = new TreeNode(7);
        TreeNode node7 = new TreeNode(8);

        node.left = node1;
        node.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;
        node3.left = node7;

        int i = TreeDepth(node);
        System.out.println(i);


    }

    static int count = 0;
    public static int TreeDepth(TreeNode root) {
        //层次遍历
        if(root == null){
            return count;
        }
        else{
            return Math.max(TreeDepth(root.left),TreeDepth(root.right))+1;
        }

    }


}





