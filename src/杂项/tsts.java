package 杂项;

public class tsts {
      public static void main(String[] args) {
          A a = new A();
          int add = a.add();
          System.out.println(add);
      }

    public double Power(double base, int exponent) {
        double num = 1;
        boolean flag = false;
        if(exponent <0){
            flag = true;
            exponent = Math.abs(exponent);
        }
        for(int i = 0 ; i < exponent ; i++){
            num = num * base;
        }

        return  flag? 1/num:num;

    }
}


class A{
    public int add(){
       int a = 1;
       int b = 2;
       int c = a+b;
       return c;
    }

}
