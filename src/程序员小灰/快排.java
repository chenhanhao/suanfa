package 程序员小灰;

import java.util.Arrays;

public class 快排 {



        public static void main(String[] args) {

            int[] a = {4,3,6,9,14,54,5,41,5};

// booSort(a,0,a.length-1);

// int[] doit = doit(a);
// System.out.println(Arrays.toString(doit));
            questSort5(a,0,a.length-1);
            System.out.println(Arrays.toString(a));
// ArrayList arrayList =new ArrayList(1);
// LinkedList linkedList = new LinkedList();
// arrayList.get(1);
// linkedList.get(1);
//
// Iterator iterator = linkedList.iterator();
// HashMap hashMap = new HashMap(1);




        }


        //冒泡排序
        public static void booSort(int[] a,int left, int right){
            for(int i = left; i<=right; i++){

                for(int j = 0; j<right-left; j++){
                    if(a[j]>a[j+1]){
                        int temp = a[j];
                        a[j] = a[j+1];
                        a[j+1] = temp;
                    }
                }
            }
        }


        //快排，挖坑
        public static void questSort5(int[] a, int left ,int right){
           //递归结束
            if(left>=right){
                return ;
            }

            int patten5 = patten5(a, left, right);

            questSort5(a,left,patten5-1);

            questSort5(a,patten5+1,right);


        }

        //挖坑法
        private static int patten5(int[] a, int left, int right) {

            int i = left;
            int j = right;
            int temp = a[left];

            while(i!=j){
                while(a[j] >= temp && i<j){
                 //j 找小
                    j--;
                }
                a[i] = a[j];

                while(a[i]< temp && i<j){
                 //找大
                    i++;
                }
                a[j] = a[i];
            }

            a[i] = temp;
            return i;
        }


        //双向循环快排
        public static void questSort(int[] a, int left , int right){
            //递归结束条件
            if(left>=right){
                return ;
            }
            //找到基准
            int patten = patten(a, left, right);
            //左边排序
            questSort(a,left,patten-1);

          //有有右边排序
            questSort(a,patten+1,right);

        }


        //分治，双向循环
        // 找出基准的下标
        public static int patten(int[] a, int start ,int end) {
            //双向指针
            int left = start;
            int right = end;
            int temp = a[start];

            while (left != right) {

             //必须右边针先移，为什么？？？因为如果没有先控制右边的过来，会导致，交换的值
               //left 跳到大的一部分，导致排序有误差
               //为什么要小于或者等于，控制指针左移动
                while (a[right] > temp && left < right) {
                    right--;
                }

                 //控制left指针，右移，a[left] 必须<=，不然出现有与temp一样的值会出现死循环，必须索引值都
                //扫描到
                while (a[left] <= temp && left < right) {
                    left++;
                }

                if (left < right) {
                    int temp2 = a[right];
                    a[right] = a[left];
                    a[left] = temp2;
                }
            }
            //pivot 和指针重合点交换
           // int pivote = a[left];
            a[start] = a[left];
            a[left] = temp;
            return left;
        }

          //单向循环，前后指针法

        public static void questSort2(int[] a,int left ,int right){
           //递归结束条件
            if(left >= right){
                return;
            }


              //找出基准元素
            int provid = patten2(a, left, right);
            System.out.println(provid);

              //分治
            questSort2(a,left,provid-1);

            questSort2(a,provid+1,right);



        }

                  //单向，前后指针

        public static int patten2(int[] a , int start , int end){
              // System.out.println(Arrays.toString(a));
            int left = start+1;
            int right = end;
            int temp = a[start];//第一个
           //mark向左是小于temp的值
            int mark = start;


            while(left<=right){
             //找到temp小的值
                if(a[left]<=temp){
                    mark++;
                     //交换
                    int k = a[left];
                    a[left] = a[mark];
                    a[mark] = k;

                }
                left++;
            }

            a[start] = a[mark];
            a[mark] = temp;
            return mark;
        }


//快排，非递归实现






        public static int[] doit(int[] arrays){
          //依次读取做异或运算
            int result = 0;

            int[] group = new int[2];

            for (int i=0;i<arrays.length;i++){
                result = result^arrays[i];
            }
            if(result==0){
                System.out.println("不符合要求");
                return group;
            }

            else{
              //确定不同位数
                int re = 1;
                while((result & re )==0){
                    re <<= 1;
                }

                   //分组
                for (int i=0;i<arrays.length;i++){
                    if((arrays[i] & re)==0){
                        group[0]=group[0]^arrays[i];
                    }
                    else {
                        group[1] = group[1]^arrays[i];
                    }

                }

                return group;

            }

        }


    }
