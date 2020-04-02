package 牛客剑指offer;

/**
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
 * 返回结果为复制后复杂链表的head。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 */
public class _20_复杂链表的复制 {
      public static void main(String[] args) {



      }

    public RandomListNode Clone(RandomListNode pHead) {
        /*
         *解题思路：
         *1、遍历链表，复制每个结点，如复制结点A得到A1，将结点A1插到结点A后面；
         *2、重新遍历链表，复制老结点的随机指针给新结点，如A1.random = A.random.next;
         *3、拆分链表，将链表拆分为原链表和复制后的链表
         */

        if(pHead==null){
            return null;
        }
        RandomListNode head =  pHead;

        //1、遍历链表，复制每个结点，如复制结点A得到A1，将结点A1插到结点A后面；
        while(head!=null){
            //复制出一个结点,也就是根据结点的值再new一个出来
            RandomListNode node =  new RandomListNode(head.label);
            //找出下一个位置
            RandomListNode next = head.next;
            head.next = node;
            node.next = next;
            head = next;
        }

        //2、重新遍历链表，复制老结点的随机指针给新结点，如A1.random = A.random.next;
        head = pHead;
        while(head!=null){

            //注意需要进行判空操作
            head.next.random = head.random==null?null:head.random.next;
            head= head.next.next;
        }

        head  = pHead;
        RandomListNode result = pHead.next;
        //3、拆分链表，将链表拆分为原链表和复制后的链表,按单双拆分,需要得到双
        while(head != null){
           RandomListNode clone = head.next;
           head.next = clone.next;
           clone.next = clone.next==null?null: clone.next.next;
           head = head.next;
        }
        return result;
    }

}





 class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}