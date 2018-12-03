/**
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 * k is a positive integer and is less than or equal to the length of the linked list.
 * If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
 * Example:
 * Given this linked list: 1->2->3->4->5
 * For k = 2, you should return: 2->1->4->3->5
 * For k = 3, you should return: 3->2->1->4->5
 * Note:
 *    Only constant extra memory is allowed.
 *    You may not alter the values in the list's nodes, only nodes itself may be changed.
 */
public class ReverseNodesInKGroup {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    class Solution {
        public ListNode reverseKGroup(ListNode head, int k) {
            if (head == null || k <=1){
                return head;
            }
            ListNode newHead, h, t, p, q;
            newHead = h = new ListNode(0);
            p = head;
            int listLength = 0;
            while (p != null) {
                listLength++;
                p = p.next;
            }
            t = p = head;
            int cycleCount = listLength / k;
            int i = 0;
            while (cycleCount > 0){
                q = p.next;
                p.next = h.next;
                h.next = p;
                p = q;
                i++;
                if (i == k) {
                    h = t;
                    t = p;
                    cycleCount--;
                    i = 0;
                }
            }
            h.next = p;
            return newHead.next;
        }
    }

    public ListNode test(){
        ReverseNodesInKGroup.Solution solution = new ReverseNodesInKGroup.Solution();
        int vals[] = new int[]{1, 2, 3, 4, 5,6};
        ListNode head, p;
        p = head = new ListNode(0);
        for (int val : vals) {
            ListNode q = new ListNode(val);
            q.next = p.next;
            p.next = q;
            p = q;
        }
//        printListNode(head.next);

//        return null;
        return solution.reverseKGroup(head.next, 4);
    }

    public static void main(String[] args) {
        ReverseNodesInKGroup reverseNodesInKGroup = new ReverseNodesInKGroup();
        ListNode listNode = reverseNodesInKGroup.test();

        printListNode(listNode);

    }

    private static void printListNode(ListNode listNode) {
        while (listNode!=null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

}
