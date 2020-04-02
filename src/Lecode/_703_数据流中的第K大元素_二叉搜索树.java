package Lecode;


public class _703_数据流中的第K大元素_二叉搜索树 {

    public static void main(String[] args) {
        int[] arr = {4,5,8,2};
        KthLargest k = new KthLargest(3, arr);
         k.add(3);
        int add = k.add(5);

        System.out.println(add);

    }
}




    class KthLargest {
         TreeNode root;
         int k;


        public  class TreeNode {
            public  int val;
            public  int num;
            public TreeNode left;
            public TreeNode right;
            public TreeNode(int x) { val = x; }
        }


        public KthLargest(int k, int[] nums) {
            this.k = k;
            //使用二叉搜索树插入
            for(int i : nums){
               root= put(root,i);
            }

        }

        public int add(int val) {
            root= put(root,val);
            int search = search(k,root);
            return search;

        }


        //二叉树搜索树结点插入,使用模板
        public TreeNode  put(TreeNode root, int val){
            if(root==null ){
                TreeNode n =  new TreeNode(val);
                n.num++;
                return n;
            }
            if(root.val == val){
                root.num++;
            }

            if(root.val < val){
                root.num++;
                root.right = put(root.right,val);
            }

            if(root.val > val){
                root.num++;
                root.left = put(root.left,val);
            }
            return  root;
        }

        //搜索二叉树，需要记录上一个结点,max记录该结点大于父节点的个数
        public int search(int k,TreeNode root){
            int mid = root.num;
            if(root.right!=null && root.left!=null){
                mid = root.right.num+1;
            }
            else if(root.right!=null){
                mid = root.right.num+1;
            }
            else if(root.left!=null){
                mid = root.num-root.left.num;
            }
            else {
                return 0;
            }


            if(mid==k){
                return root.val;
            }
            if(mid>k){

                return  search(k,root.right);

            }
            if(mid<k){
                return search(k-mid,root.left);

            }

            return root.val;
        }





    }







