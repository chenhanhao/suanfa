package 牛客剑指offer;

import java.util.ArrayList;

/**
 * 输入一个链表，按链表从尾到头的顺序返回一个ArrayList
 */
public class _2_3_从未到头打印数组 {

  public static void main(String[] args) {
      ListNode listNode = new ListNode(1);
      ListNode listNode2 = new ListNode(2);
      ListNode listNode3= new ListNode(3);
      listNode.next = listNode2;
      listNode2.next = listNode3;
      printListFromTailToHead(listNode);
  }



    public static class ListNode {
         int val;
          ListNode next = null;
           ListNode(int val) {
            this.val = val;
        }
    }

   static  ArrayList<Integer> list = new ArrayList<Integer>();


        public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
            ListNode next = listNode.next;
            if(next!=null) {
                printListFromTailToHead(next);

            }
            System.out.println(listNode.val);
            list.add(listNode.val);

            return list;
        }




        public ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
            ArrayList<Integer> list = new ArrayList();
            //listNode node = listNode.next;

            while(listNode!=null){
                list.add(listNode.val);
                listNode = listNode.next;

            }
            ArrayList<Integer> result = new ArrayList();

            for(int i = list.size()-1;i>=0;i--){
                result.add(list.get(i));
            }
            return result;
        }


}
