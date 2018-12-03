/**
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 */
public class AddTwoNumbers {

     public class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; }
     }

    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            int j = 0;//进位
            int val = l1.val + l2.val;
            if (val > 9) {
                val = val - 10;
                j = 1;
            } else {
                j = 0;
            }
            ListNode head = new ListNode(val);
            ListNode current = head;
            ListNode p1 = l1.next;
            ListNode p2 = l2.next;
            while (p1 != null || p2 != null || j != 0) {
                val = j;
                if (p1 != null) {
                    val = val + p1.val;
                    p1 = p1.next;
                }
                if (p2 != null) {
                    val = val + p2.val;
                    p2 = p2.next;
                }
                if (val > 9) {
                    val = val - 10;
                    j = 1;
                } else {
                    j = 0;
                }
                current.next = new ListNode(val);
                current = current.next;
            }
            return head;
        }
    }

    public void test(){
        Solution solution = new AddTwoNumbers.Solution();
        solution.addTwoNumbers(null, null);
    }

    public static void main(String[] args) {
        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        addTwoNumbers.test();
    }
}
