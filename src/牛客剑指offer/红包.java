package 牛客剑指offer;

import java.util.Arrays;
import java.util.Random;

public class 红包 {

    /**
     * @param count 红包数
     * @param money 总金额
     * @return
     */
    public static Integer[] ranRedPac(Integer count, Integer money) {
        Integer[] result = new Integer[count];
        for (int i = 1; i <= money; i++) {
            int n = new Random().nextInt(count);
            result[n] = result[n] == null ? 1 : result[n] + 1;
        }
        return result;
    }

    //测试
    public static void main(String[] args) {
        Arrays.asList(ranRedPac(10, 10)).forEach(i -> System.out.println(i));
        System.out.println("sum: " + Arrays.asList(ranRedPac(10, 50)).stream().mapToInt(i -> i).sum());
    }
}
