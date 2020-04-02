package Lecode.二叉搜索树;

import Util.TreeNode;

import java.util.Stack;

//中序遍历 STB 使用中序遍历的思想实现了树的遍历
public class _173_二叉搜索树迭代器 {
     public static void main(String[] args) {

     }

    class BSTIterator {
         Stack<TreeNode> st = new Stack<>();

        public BSTIterator(TreeNode root) {
            push( root);

        }

        public void push(TreeNode root){
            //将所有左节点都入栈
            while(root!=null){
                st.push(root);
                root = root.left;
            }
        }

        /** @return the next smallest number */
        public int next() {
            if(!st.isEmpty()){
                TreeNode node = st.pop();
                //将右节点入栈
                if(node.right!=null){
                    push(node.right);

                }
                return node.val;

            }
          else {
                return 0;
            }
        }


        /** @return whether we have a next smallest number */
        public boolean hasNext() {
           return !st.isEmpty();
        }
    }
}
