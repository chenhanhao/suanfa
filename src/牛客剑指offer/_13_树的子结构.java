package 牛客剑指offer;

import java.util.ArrayDeque;

/**
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 */
public class _13_树的子结构 {

     public static void main(String[] args) {

     }


    public boolean HasSubtree(TreeNode p,TreeNode q) {

         if(p==null || q == null){
             return false;
         }

       //我现在已经有了可以判断两棵树的方法，，那我现在一个专门去遍历这一课树？递归？层次？
         while(p!=null){
           return  checkTree(p,q) || HasSubtree(p.left,q) || HasSubtree(p.right,q);

         }
         return true;


    }





     //首先需要有一个可以判断两棵树是否是相同结构的二叉树树的函数
    //方法一：递归: 首先判断p与q 是否都不为Null ,如果都不为null, 则判断是否相等，
    // 相等则继续递归判断其子结构,放回递归结构，否则则放回false

     public static boolean checkTree(TreeNode p, TreeNode q){


         //到了根结点，退出递归,只需要q ,如果递归到q==null,说明之前的结点都相同了
         if(q==null ){
             return true;
         }

         if(p==null || q==null){
               return false;
           }

         if(p.val!= q.val){
               return false;
         }

         //递归其子结构
         return checkTree(p.left, q.left) && checkTree(p.right, q.right);

     }

     //方法二--------------------------------------------------------------------------

     //判断两个结点是否一样的方法
     public static boolean cheak(TreeNode p, TreeNode q){
         if(p == null  && q==null){
             return true;
         }

         if(p==null || q == null){
             return false;
         }

         if(p.val!= q.val){
             return false;
         }
         return true;
     }

     //方法二：
    public static boolean checkTree2(TreeNode p, TreeNode q){
          if(p == null  && q==null){
              //注意这里需要这个，但一开始两个数就是空树时，我们需要返回true
            return true;
           }
              if(!cheak(p,q)){
              return false;
              }
              //分别建立两个队列
              ArrayDeque<TreeNode> pdeque = new ArrayDeque<>();
              ArrayDeque<TreeNode> qdeque = new ArrayDeque<>();


              pdeque.addLast(p);
              qdeque.addLast(q);


              //只需要判断p队列即可：因为这两个队列是相辅相成的
              while (!pdeque.isEmpty() ){

                  p = pdeque.removeFirst();
                  q = qdeque.removeFirst();

                  if(!cheak(p,q)){
                      return false;
                  }

                  //需要判空
                  if(p==null){
                       return false;
                  }

                  //比较左结点
                  if(!cheak(p.left,q.left)){
                      return false;
                  }

                  //比较右结点
                  if(!cheak(p.right,q.right)){
                      return false;
                  }

                  if(p.left!=null) {
                      pdeque.addFirst(p.left);
                      qdeque.addFirst(q.left);
                  }


                  if(p.right!=null) {
                      pdeque.addFirst(p.right);
                      qdeque.addFirst(q.right);
                  }

              }

              return true;

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
