package 牛客剑指offer;

/**
 * @author ASNPIHA
 * @date 2019-12-16 3:06 PM
 */

/**
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，
 * 当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 */
public class _2_2_替换空格 {

    public static void main(String[] args) {
        String nn = "We Are Happy";
        System.out.println(tran(nn));


    }

    static String  tran(String a){
        String b = a.trim();
        String s = b.replaceAll(" ", "%20");

        return s;
    }
}
