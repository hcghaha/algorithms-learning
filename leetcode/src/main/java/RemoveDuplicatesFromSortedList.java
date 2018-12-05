/**
 * function: Given a sorted linked list, delete all duplicates such that each element appear only once.
 * Created by huangchaoguang on 2018/12/4.
 */
public class RemoveDuplicatesFromSortedList {

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
        ListNode head = ListUtils.createList(new int[]{1, 1, 2, 2, 2, 3, 3,6});
        return solution.deleteDuplicates(head);
    }
    public static void main(String[] args) {
        RemoveDuplicatesFromSortedList main = new RemoveDuplicatesFromSortedList();
        ListNode listNode = main.test();
        ListUtils.printList(listNode);

    }

}
