package 牛客剑指offer;

import java.util.HashSet;

public class test {

     public static void main(String[] args) {
         System.out.println(56465%19);
         System.out.println(56465&18);




        String a ="123";
        String  b = "123";
        System.out.println(a.hashCode());
         System.out.println(b.hashCode());


        A n = new A("123",1);
        A m = new A("123",1);
        System.out.println(n.hashCode());
        System.out.println(m.hashCode());
        System.out.println(n.equals(m));
        // System.out.println(n==m);

         HashSet<A> set  = new HashSet<>();
         set.add(n);
         set.add(m);
         System.out.println(set.size());
     }
}

class A{
    private String a;
    private int b;

    public A(String a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public int hashCode() {
       return b*a.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        A B = (A)obj;
        return this.a.hashCode()*this.b == B.a.hashCode()*B.b;
    }
}
