package 牛客剑指offer;

import java.util.ArrayList;

/**
 * {10,5,12,4,7},22
 */
public class _19_二叉树中和为某一路径 {

     public static void main(String[] args) {

//          ArrayList list1 = new ArrayList();
//          ArrayList list2 = new ArrayList();
//          list2.add(123);
//          list2.add(555);
//          //list1.add(new ArrayList<>(list2));
//          list1.add(list2);
//          System.out.println(list1.toString());

          TreeNode root = new TreeNode(10);
          TreeNode left = new TreeNode(5);
          TreeNode right = new TreeNode(12);
          TreeNode left1 = new TreeNode(4);
          TreeNode right1 = new TreeNode(7);
          left.right = right1;
          left.left = left1;
          root.left=left;
          root.right = right;
          ArrayList<ArrayList<Integer>> arrayLists = FindPath(root, 22);
          System.out.println(arrayLists.toString());

     }

     private static ArrayList<ArrayList<Integer>> listAll = new ArrayList<ArrayList<Integer>>();
     private static ArrayList<Integer> list = new ArrayList<Integer>();
     public static ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {


           //确定递归出口
           if(root==null){
                return listAll;
           }

          //首先取根结点的值
           list.add(root.val);
           //结果减去根结点的值
           target -= root.val;

           if(target==0 && root.left==null && root.right==null ){
               //注意不可以传入list值，这样子会在后面被修改，需要重新构造一个list的值传入
                listAll.add(new ArrayList<Integer>(list));
           }

           //遍历左边
          FindPath(root.left,target);
          //遍历右边
          FindPath(root.right,target);
          //回溯要减去最后一个结点
          list.remove(list.size()-1);
          return listAll;

     }


     public static class TreeNode {
          int val = 0;
          TreeNode left = null;
          TreeNode right = null;

          public TreeNode(int val) {
               this.val = val;

          }
     }


}
