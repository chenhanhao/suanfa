package Lecode;

import Util.CreatListNode;
import Util.ListNode;

import java.util.ArrayList;

public class _876_链表的中心节点 {
     public static void main(String[] args) {
         int [] arr = {1,2,3,6,4,5};
         ListNode head = CreatListNode.getArrayToListNode(arr);
         ListNode listNode = middleNode(head);
         System.out.println(listNode.val);
     }

     //快慢指针
     public static ListNode middleNode(ListNode head) {
         ListNode slow = head, fast = head;
         while(fast!=null  && fast.next!=null){
             fast = fast.next.next;
             slow = slow.next;
         }
         return slow;

     }


     //垃圾暴力
    public static ListNode middleNode2(ListNode head) {
        ArrayList<ListNode> list = new ArrayList<>();
        while(head!=null){
            list.add(head);
            head = head.next;
        }
        int sum = list.size();
        return list.get(sum/2);
    }

}



