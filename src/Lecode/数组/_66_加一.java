package Lecode.数组;

//重点是 只有两种情况 是9加一以及9之外的数字加一
public class _66_加一 {
     public static void main(String[] args) {

         int[] a = {1,2,3};
         System.out.println(plusOne(a));
     }
    public static int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0) return digits;
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }

}
