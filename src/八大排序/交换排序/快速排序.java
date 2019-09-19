package 八大排序.交换排序;

/**
 * 分治思想，有一个“基准值”，根据基准值，小的在左，大的放右，最后递归合并
 * 基线条件：数组为空，或者数组只包含一个数，此时无须排序
 * 递归条件
 *
 */
public class 快速排序 {


    /**
     * 实现快速排序： 基准数归位的过程
     *
     * @param arr
     * @param left
     * @param right
     */
    public void quickSort(long[] arr, int left, int right) {
        int i = 0;
        int j = 0;
        long pivot = 0;
        long tmp = 0;

        if(left >= right) {
            return;
        }

        i = left;
        j = right;
        // refer存储基准数（初始化为数组第一个数，即左边）
        pivot = arr[left];

        // 当i = j （即相遇）时跳出循环
        while (i < j) {

            // 注意找的顺序，右边扫描
            // 先从右往左找(找到小于基准数)
            while (i < j && pivot <= arr[j]) {
                // 往左找
                j--;
            }

            // 再从左往右找（找到大于基准数）
            while (i < j && pivot >= arr[i]) {
                // 往右找
                i++;
            }

            // 当i 与 j 没有相遇
            if (i < j) {
                // 交换两个数的位置
                tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;

            }
        }

        // 此时i = j 相遇了
        // 最终将基准数的位置与i=j相遇的位置交换
        arr[left] = arr[i];
        // 基准数归位
        arr[i] = pivot;

        // 递归排序，对左边的子数组进行快速排序
        quickSort(arr,left, i - 1);
        // 对右边的子数组进行快速排序
        quickSort(arr,i + 1, right);

    }




     public static void main(String[] args) {


     }
}
