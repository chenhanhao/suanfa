package Util;

public class CreatListNode {

    public  static  ListNode getArrayToListNode(int[] arr){
        ListNode head = new ListNode(arr[0]);
        ListNode node = head;
        for(int i = 1 ; i <arr.length; i++){
            ListNode nextnode = new ListNode(arr[i]);
            node.next = nextnode;
            node = nextnode;
        }
        return head;

    }
}



