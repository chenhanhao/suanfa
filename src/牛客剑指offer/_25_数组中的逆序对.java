package 牛客剑指offer;

/**
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007
 */
public class _25_数组中的逆序对 {

    static int count = 0;
     public static void main(String[] args) {
         int[] arr= {1,2,3,4,9,6,7,0};
         sort(arr,0,arr.length-1);
         System.out.println(count);


     }

    //归并排序
    public static void sort(int[] arr , int left , int right){

        //出口
        if(left==right){
            return;
        }
        //中间值为左边加上右边与左边之差除以2的值（两个节点之间的距离+起始点）
        int mid  = left+((right-left)>>1);
        //递归左边
        sort(arr, left, mid);
        //递归右边
        sort(arr,mid+1,right);
        //进行合并
        merge(arr,left,mid,right);
    }

    //合并两个数组
    private static void merge(int[] arr, int left, int mid, int right) {
        //第一个数组，从left开始，在mid结束
        //第二数组，从mid+1开始，right结束
        //如何合并两个数组

        //比较左两个数组
        //缓存结果的数组
        int[] temp = new int[right-left+1];
        int l = left;
        int r = mid+1;
        int i = 0;
        while(l<=mid && r<=right){
            if(arr[l]<arr[r]){
                temp[i++] = arr[l++];

            }
            if(arr[l]>arr[r]){
                temp[i++] = arr[r++];
                count = (count+mid-l+1)%1000000007;
            }
           // temp[i++] = arr[l] < arr[r] ? arr[l++] : arr[r++];

        }

        //将剩余的加到数组结尾
        while(l<=mid){
            temp[i++] = arr[l++];
        }

        while(r<=right){
            temp[i++] = arr[r++];
        }

        //将数据替换原来数组
        for(int  k = 0 ; k < temp.length;k++ ){
            arr[left++] = temp[k];
        }
    }
}
