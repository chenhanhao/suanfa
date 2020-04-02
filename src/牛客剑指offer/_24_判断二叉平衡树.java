package 牛客剑指offer;
/**
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 */

public class _24_判断二叉平衡树 {

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

//        int i = TreeDepth(node,0);
//        System.out.println(i);
        int i = TreeDepth(node);
        System.out.println(i);


    }





    //求出层次数
    public static int TreeDepth(TreeNode root) {
        //层次遍历
        if(root == null){
            return 0;
        }

        //递归左子树
        int left = TreeDepth(root.left);
        if(left==-1){
            return -1;
        }
        //递归右子树
        int right = TreeDepth(root.right);
        if(right==-1){
            return -1;
        }

        if(Math.abs(left-right)>1){
            //绝对值大于1
            return -1;
        }
        else {
            return 1+(left > right?left:right);
        }




    }

}

