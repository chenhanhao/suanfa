package 杂项;

public class a的N次方递归再优化 {

        static long[] arr = new long[100];
        public static void main(String[] args) {
            int a = 2;
            int n = 6;


            long t = System.nanoTime(); // 纳秒
            System.out.println(pow0(a, n));
            System.out.println("pow0()所花时间："+(System.nanoTime()-t)+"ns");

            t = System.nanoTime();
            System.out.println(pow(a, n));
            System.out.println("pow()所花时间："+(System.nanoTime()-t)+"ns");


            t = System.nanoTime();
            System.out.println(pow2(a, n));
            System.out.println("pow2()所花时间："+(System.nanoTime()-t)+"ns");

            t = System.nanoTime();
            System.out.println(pow3(a, n));
            System.out.println("pow3()所花时间："+(System.nanoTime()-t)+"ns");


        }



    // O(N)
        private static long pow0(int a,int n){
            long res = 1;
            for(int i=0;i<n;i++){
                res *= a;
            }
            return res;
        }

        private static long pow(int a,int n){
            if (n==0) {
                return 1;
            }
            long res = a;
            int ex = 1;
            while((ex<<1)<=n){
                res = res * res;
                ex <<=1;
            }
            return res*pow(a, n-ex);
        }


        private static long pow2(int a, int n){
            if(n==1){
                return a;
            }

            //一个数与1相与，结果为1时，为奇数
            //一个数与1相与，结果为0时，为偶数
            if((n&1)==0){
                  //偶数
                if(arr[n]!=0){
                    return arr[n];
                }
                arr[n] = pow2(a,n>>1)*pow2(a,n>>1);
                return arr[n];

            }
            else {
                //奇数
                if(arr[n]!=0){
                    return arr[n];
                }
                arr[n] =  pow2(a,n>>1)*pow2(a,(n>>1)+1);
                return arr[n];

            }
        }



        private static long pow3(int a, int n){
            if(n==1){
                return a;
            }

            if((n&1)==0){
                //偶数
                return pow3(a,n>>1)*pow3(a,n>>1);

            }
            else {
                   //奇数
                return pow3(a,n>>1)*pow3(a,(n>>1)+1);

            }
        }


    }

