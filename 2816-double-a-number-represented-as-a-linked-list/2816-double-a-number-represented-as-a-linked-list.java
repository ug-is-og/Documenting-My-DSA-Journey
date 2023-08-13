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
    public ListNode doubleIt(ListNode head) {
        // reverse the links of singly linked list
        ListNode prev=head;
        ListNode slow=head.next;
        prev.next=null;
        while(slow!=null)
        {
            ListNode temp=slow.next;
            slow.next=prev;
            prev=slow;
            slow=temp;
        }
        ListNode newHead=prev;
        // perform the calculations
        ListNode newNode=null;
        ListNode tempHead=newHead;
        prev=newHead;
        int carry=0;
        while(tempHead!=null)
        {
            int mul=tempHead.val*2+carry;
            if(mul>9)
                carry=1;
            else
                carry=0;
            int firstPlace=mul%10;
            tempHead.val=firstPlace;
            prev=tempHead;
            tempHead=tempHead.next;
        }
        if(carry==1)
        {
            newNode=new ListNode(1);
            prev.next=newNode;
        }
        // reverse the links again
        prev=newHead;
        slow=newHead.next;
        prev.next=null;
        while(slow!=null)
        {
            ListNode temp=slow.next;
            slow.next=prev;
            prev=slow;
            slow=temp;
        }
        ListNode ansHead=prev;
        return ansHead;
    }
}