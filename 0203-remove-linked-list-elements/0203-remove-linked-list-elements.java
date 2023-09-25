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
    public ListNode removeElements(ListNode head, int val) {
        if(head==null)
        return head;
        if(head.next==null)
        {
            if(head.val==val)
            return null;
            return head;
        }
        ListNode prev=head,curr=head.next;
        while(curr!=null)
        {
            if(prev.val==val)
            {
                prev=prev.next;
                curr=curr.next;
                head=prev;
            }
            else
            {
                if(curr.val==val)
                {
                    prev.next=curr.next;
                    curr=curr.next;
                }
                else
                {
                    prev=prev.next;
                    curr=curr.next;
                }
            }
        }
        if(prev.val==val)
        return prev.next;
        return head;     
    }
}
