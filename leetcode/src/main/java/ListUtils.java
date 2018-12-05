/**
 * Created by huangchaoguang on 2018/12/5.
 */
public class ListUtils {
    public static ListNode createList(int vals[]){
        ListNode head, p;
        p = head = new ListNode(-1);
        for (int val : vals) {
            ListNode q = new ListNode(val);
            q.next = p.next;
            p.next = q;
            p = q;
        }
        return head.next;
    }

    public static void printList(ListNode listNode) {
        while (listNode!=null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
