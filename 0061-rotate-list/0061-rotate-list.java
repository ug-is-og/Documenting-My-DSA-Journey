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
        if(head==null||head.next==null)
        {
            return head;
        }
        ListNode tail=null;
        // count the no of nodes
        ListNode temp=head;
        int count=0;
        while(temp!=null)
        {
            if(temp.next==null)
            {
                tail=temp;
            }
            count++;
            temp=temp.next;
        }
        k=k%count;
        if(k==0)
        {
            return head;
        }
        temp=head;
        for(int i=1;i<=count-k-1;i++)
        {
            temp=temp.next;
        }
        ListNode temp2=temp.next;
        temp.next=null;
        tail.next=head;
        return temp2;
    }
}