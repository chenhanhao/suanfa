package 程序员小灰;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Random;

public class _6_5_红包拆分 {

    public static void main(String[] args) {
        HashMap<Integer,Integer> map = divideRed(10, 1000);
        map.forEach((key,value)->System.out.println(new BigDecimal(value).divide(new BigDecimal(100))));
    }



  public  static HashMap<Integer,Integer> divideRed(int peopleNum, int count){
        int  realNum = peopleNum;
        int  realCount = count;

        Random random = new Random();
       HashMap<Integer,Integer> map = new HashMap<>(peopleNum);
        for (int i = 0; i<peopleNum-1;i++){
            int  money = random.nextInt((realCount/realNum)*2-1)+1;
            map.put(i+1,money);
            realNum--;
            realCount -= money;
        }
        map.put(peopleNum,realCount);
        return  map;
    }
}