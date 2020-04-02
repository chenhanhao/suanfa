package Lecode;

public class _62_圆圈中最后剩下的数字 {
     public static void main(String[] args) {
         int i = lastRemaining(5, 1);
         System.out.println(i);

     }

    public static int lastRemaining(int n, int m) {

         ListNode head = new ListNode(0);
         ListNode tempnode = head;
         for(int i = 1 ; i < n; i++){
             ListNode node = new ListNode(i);
             tempnode.next = node;
             tempnode = node;
         }
         if(m==1){
             return tempnode.value;
         }
         tempnode.next = head;


         //进行对结点的删除
       while(head.next!=head){
          for(int j=1; j<m-1; j++){
              head = head.next;
          }

          ListNode node =  head.next.next;
          head.next = node;
          head = node;

       }

       return head.value;

    }



     static class ListNode{
         public   ListNode next;
         private    int value;

        ListNode(int value){
           this.value = value;
       }

    }
}
