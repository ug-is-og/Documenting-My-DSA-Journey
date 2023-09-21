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
    public int getDecimalValue(ListNode head) {
        // count total no of nodes
        ListNode temp=head;
        int ans=0,count=0;
        while(temp!=null)
        {
            count++;
            temp=temp.next;
        }
        int maxPow=count-1;
        temp=head;
        while(temp!=null)
        {
            ans=ans+((int)Math.pow(2,maxPow))*temp.val;
            temp=temp.next;
            maxPow=maxPow-1;
        }
        return ans;
    }
}