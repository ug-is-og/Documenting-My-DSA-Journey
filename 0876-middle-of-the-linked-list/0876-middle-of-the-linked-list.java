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
    public ListNode middleNode(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        // yeh condition ratne ki koi zarurat nahi, dikakt ho jayegi , iss question mein hame bola tha ki hame even size ke cases mein second mid chahiye toh uss hisaab se kaam banaya
        // don't mug up
        while(fast!=null&&fast.next!=null)// yeh bhot dhyan se dekhna agar condition mein
        // ordering change kardi toh ans galat aa jayega, agar (fast.next!=null&&fast!=null)
        // kiya toh tum null ka next check karne lage for even sized linked list toh thoda sambhal ke
        {
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
}