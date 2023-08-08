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

// Approach 1 fuddu si stacks ke through
// unnecessary complications kar rakhi hai
// O(n) SC and O(n) TC

// class Solution {
//     public boolean isPalindrome(ListNode head) {
//         if(head==null)
//         return true;
//         Stack<ListNode> check=new Stack<>();
//         ListNode temp=head;
//         while(temp!=null)
//         {
//             check.push(temp);
//             temp=temp.next;
//         }
//         return checkPalindrome(head,check);
//     }
//     public boolean checkPalindrome(ListNode start,Stack<ListNode> check)
//     {
//         if(check.peek()==start)
//         return true;
//         if(start.next==check.peek())
//         {
//             if(start.val==check.peek().val)
//             return true;
//             else
//             return false;
//         }
//         if(start.val==check.peek().val)
//         {
//             check.pop();
//             return checkPalindrome(start.next,check);
//         }
//         return false;
//     }

// }


// Approach 2 is using arrays simply and checking for palindrome through it
// O(n) SC and O(n) TC

// this approach combines the slow, fast pointer approach and the approach of iterative
// reversal of the linked list
// O(1) SC and O(n) TC

class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode slow=head,fast=head;
        while(fast!=null&&fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode prev=slow;
        slow=slow.next;
        prev.next=null;
        while(slow!=null)
        {
            ListNode temp=slow.next;
            slow.next=prev;
            prev=slow;
            slow=temp;
        }
        // now prev will be at the last node of linked list where second half pointers are reversed
        ListNode temp=head;
        while(prev!=null)
        {
            if(prev.val!=temp.val)
            return false;
            prev=prev.next;
            temp=temp.next;
        }
        return true;
    }
}