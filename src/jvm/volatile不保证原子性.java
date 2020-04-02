package jvm;

public class volatile不保证原子性 {
    volatile static int count = 0;
    public static void add(){
        count++;
    }

     public static void main(String[] args) {

        for(int i = 0 ; i< 10 ;i++){
            Thread thread = new Thread(()->{
                for(int j = 0 ; j < 1000; j++){
                    count++;
                    //++操作并不是原子性的
                    //第一步： 读count值
                    //第二步： count++
                }
            });
            thread.start();
        }

        try{
            Thread.sleep(5000);
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }

        System.out.println(count);
     }


}
