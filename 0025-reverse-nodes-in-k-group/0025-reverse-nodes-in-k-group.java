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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp=head,kthnode=null,nextnode=null,sub=null;
        while(temp!=null){
            kthnode=findkthnode(temp,k);
            if(kthnode==null){
                if(sub!=null)
                    sub.next=temp;

                    break;
            }
            nextnode=kthnode.next;
            kthnode.next=null;
            reverse(temp);

            if(head==temp){
                head=kthnode;
            }
            else{
                sub.next=kthnode;
            }
            sub=temp;
            temp=nextnode;
        }
        return head;
    }

    ListNode findkthnode(ListNode temp,int k){
        int i=1;
        while(temp!=null && i<k){
            temp=temp.next;
            i++;
        }
        return temp;
    }
    void reverse(ListNode temp){
        ListNode curr=temp,prev=null,temp1=null;
        while(curr!=null){
            temp1=curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp1;
        }
    }
}