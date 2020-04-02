package 牛客剑指offer;

import java.util.Arrays;

/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同
 */
public class _18_二叉搜索树的后续遍历 {
    //提问：什么是二叉搜索树？
    //在出子数组
    //每一个子数组的那最后一个数是跟结点
    //根结点大于左节点的数，小于右节点的数
     public static void main(String[] args) {
         int[] a = {5,4,3,2,1};
         System.out.println(VerifySquenceOfBST(a));
     }

    public static  boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence.length==0 ){
            return false;
        }
         if(sequence.length==1 ){
             return true;
         }
         else{
             //拿数组的最后一个数为根
             int root = sequence[sequence.length-1];
             //从左遍历数组，找比根大的数，得出出右子树
             int i = sequence.length-2;
             while (sequence[i]>root && i>0){
                 i--;
             }
             //找出下标，取得右子树
             int[] right = Arrays.copyOfRange(sequence, i, sequence.length - 1);
             //取得左子树
             int[] left = Arrays.copyOfRange(sequence, 0, i);

             //判断左子树是不是都小于根
             for(int j = left.length-1; j>=0;j--){
                 if(left[j]>root){
                     return false;
                 }
             }

             if(left.length==0 && right.length!=0){
                 return VerifySquenceOfBST(right);
             }
             if(left.length!=0 && right.length==0){
                 return VerifySquenceOfBST(left);
             }
             return VerifySquenceOfBST(left) && VerifySquenceOfBST(right);
         }
    }


}
