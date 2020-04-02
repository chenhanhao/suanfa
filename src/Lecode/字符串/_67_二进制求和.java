package Lecode.字符串;

public class _67_二进制求和 {
     public static void main(String[] args) {
         String s = addBinary("11", "1");
         System.out.println(s);

         String abc = "abc";
         System.out.println(abc.indexOf("b"));
     }

//    //得到两个数组，将短的数组补齐0，使得两个数组的长度一致，可以直接进行运算，一位一位从后开始计算
//    public static String addBinary(String a, String b) {
//        StringBuilder ans = new StringBuilder();
//        int ca = 0;
//        for(int i = a.length() - 1, j = b.length() - 1;i >= 0 || j >= 0; i--, j--) {
//            int sum = ca;
//            sum += i >= 0 ? a.charAt(i) - '0' : 0;
//            sum += j >= 0 ? b.charAt(j) - '0' : 0;
//            ans.append(sum % 2);
//            ca = sum / 2;//进位
//        }
//        ans.append(ca == 1 ? ca : "");
//        return ans.reverse().toString();
//    }



    public static String addBinary(String a, String b) {
         //得到两个数组，将短的数组补齐0，使得两个数组的长度一致，可以直接进行运算，一位一位从后开始计算
        char[] achar = a.toCharArray();
        char[] bchar = b.toCharArray();


        int temp = 0;//记录进位
        StringBuilder str = new StringBuilder();
        for(int i = achar.length-1, j = bchar.length-1; i>=0 || j >=0 ; i--,j-- ){
            int aa = i<0 ? 0 : achar[i]-'0'; int bb = j<0 ? 0: bchar[j]-'0';
            int add = aa+bb+temp;

            str.append(add%2);

            temp = add/2;//余数
        }

        if(temp==1){
            str.append(1);
        }
        return str.reverse().toString();

    }



     //下面的方式没有考虑int 的大小限制

//    public static String addBinary2(String a, String b) {
//        char[] achar = a.toCharArray();
//        char[] bchar = b.toCharArray();
//
//        int atemp = 1;
//        int aa = 0;
//        for(int i = achar.length-1 ; i >= 0 ; i--){
//
//            if(achar[i]==49){
//                aa += atemp;
//            }
//            atemp <<= 1;
//        }
//
//        int btemp = 1;
//        int bb = 0;
//        for(int i = bchar.length-1 ; i >= 0 ; i--){
//
//            if(bchar[i]==49){
//                bb += btemp;
//            }
//            btemp <<= 1;
//        }
//
//        int res = aa+bb;
//
//        StringBuilder str = new StringBuilder();
//        ArrayList<Integer> list  =new ArrayList();
//         while(res!=0){
//             if(res%2==0){
//                 list.add(0);
//             }
//             else{
//                list.add(1);
//             }
//
//             res = res >> 1;
//         }
//
//       for(int i = list.size()-1; i>=0; i--){
//           str.append(list.get(i));
//       }
//
//
//       return str.length()==0? "0": str.toString();
//    }

//    public static String addBinary(String a, String b) {
//        char[] achar = a.toCharArray();
//        char[] bchar = b.toCharArray();
//
//        int aa = 0;
//        int bb = 0;
//
//        for(int i = 0 ; i < achar.length; i++){
//            aa = aa*10 + (achar[i]-48);
//        }
//        for(int i = 0 ; i < bchar.length; i++){
//            bb = bb*10 + (bchar[i]-48);
//        }
//
//       int res = aa+bb;
//
//        //如何求一个数的二进制？
//        StringBuilder str = new StringBuilder();
//        ArrayList<Integer> list  =new ArrayList();
//         while(res!=0){
//             if(res%2==0){
//                 list.add(0);
//             }
//             else{
//                list.add(1);
//             }
//
//             res = res >> 1;
//         }
//
//       for(int i = list.size()-1; i>=0; i--){
//           str.append(list.get(i));
//       }
//
//        return str.toString();
//
//    }
}
