/**
 * function: Given a sorted linked list, delete all duplicates such that each element appear only once.
 * Created by huangchaoguang on 2018/12/4.
 */
public class RemoveDuplicatesFromSortedList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            if (head == null) return null;
            ListNode p, q;
            p = head;
            q = p.next;
            while (q != null) {
                if (p.val == q.val){
                    p.next = q.next;
                } else {
                    p = q;
                }
                q = p.next;
            }
            return head;
        }
    }


    public ListNode test(){
        Solution solution = new Solution();
        int vals[] = new int[]{1, 1, 2, 2, 2, 3, 3,6};
        ListNode head, p;
        p = head = new ListNode(-1);
        for (int val : vals) {
            ListNode q = new ListNode(val);
            q.next = p.next;
            p.next = q;
            p = q;
        }
//        printListNode(head.next);

//        return null;
        return solution.deleteDuplicates(head.next);
    }
    public static void main(String[] args) {
        RemoveDuplicatesFromSortedList main = new RemoveDuplicatesFromSortedList();
        ListNode listNode = main.test();
        printListNode(listNode);

    }

    private static void printListNode(ListNode listNode) {
        while (listNode!=null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

}
