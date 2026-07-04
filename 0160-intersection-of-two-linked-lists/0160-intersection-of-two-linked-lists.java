/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        ListNode head = headA;
        ListNode tail = headB;

        while (head != tail) {

            if (head == null) {
                head = headB;
            } else {
                head = head.next;
            }

            if (tail == null) {
                tail = headA;
            } else {
                tail = tail.next;
            }
        }

        return head;
    }
}