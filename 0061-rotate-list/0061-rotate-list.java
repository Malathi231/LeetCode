/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {

        if (head == null || head.next == null || k == 0) {
            return head;
        }

        // Find length
        int length = 0;
        ListNode temp = head;

        while (temp != null) {
            length++;
            temp = temp.next;
        }

        k = k % length;

        while (k > 0) {

            ListNode prev = null;
            ListNode curr = head;

            // Reach the last node
            while (curr.next != null) {
                prev = curr;
                curr = curr.next;
            }

            // Move last node to front
            prev.next = null;
            curr.next = head;
            head = curr;

            k--;
        }

        return head;
    }
}