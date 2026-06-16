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
    public ListNode deleteMiddle(ListNode head) {
        ListNode temp=head;
        int length=0;
        if(head.next==null){
            return null;
        }
        while(temp!=null){
            length++;
            temp=temp.next;
        }
        int mid=length/2;
        temp=head;
        
        for(int i=1;i<mid;i++){
            temp=temp.next;
        }
        temp.next = temp.next.next;

        return head;
    }
}