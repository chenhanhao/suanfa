package Util;

public class CreatTreeNode {
   public static TreeNode getTree(int[] arr){
       TreeNode root = new TreeNode(arr[0]);

       TreeNode creat = creat(arr,0,root);
       return creat;

   }

   public static TreeNode creat(int[] arr,int n , TreeNode node){
        for(int i = n ; i < arr.length ;i++) {
            TreeNode left = null;
            TreeNode right = null;

            if ((i + 1) * 2 - 1 < arr.length) {
                left = new TreeNode(arr[(i + 1) * 2 - 1]);
                creat(arr,(i + 1) * 2 - 1, left);
            }

            if ((i + 1) * 2 < arr.length) {
                right = new TreeNode(arr[(i + 1) * 2]);
                creat(arr,(i + 1) * 2, right);
            }

            node.left = left;
            node.right = right;

        }

        return node;


       }

}
